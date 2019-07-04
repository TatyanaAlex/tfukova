package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Class TrackerSQL.
 *
 * @author Tatyana Fukova (mailto:tatyanafukova@gmail.com)
 * @version $I$
 * @since 01.06
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private static final String TABLE_ITEMS = "Items";
    private static final Random RANDOM = new Random();

    private Connection connection;

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method adds new item.
     *
     * @param item **created item**
     * @return item
     */
    @Override
    public Item add(Item item) {
        item.setId(String.valueOf(RANDOM.nextInt()));
        String sql = "INSERT INTO " + TABLE_ITEMS + "(id, name, description, created_on) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, Integer.valueOf(item.getId()));
            pst.setString(2, item.getName());
            pst.setString(3, item.getDescription());
            pst.setTimestamp(4, new Timestamp(item.getCreate()));
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Method changes the item.
     *
     * @param itemToUpdate **item that will be changed**
     */
    @Override
    public void update(Item itemToUpdate) {
        String sql = "UPDATE " + TABLE_ITEMS + " SET name=?, description=?, created_on=? WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, itemToUpdate.getName());
            pst.setString(2, itemToUpdate.getDescription());
            pst.setLong(3, itemToUpdate.getCreate());
            pst.setInt(4, Integer.valueOf(itemToUpdate.getId()));
            pst.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method deletes the item.
     *
     * @param itemToDelete **item that will be deleted**
     */
    @Override
    public void delete(Item itemToDelete) {
        String sql = "DELETE " + TABLE_ITEMS + "WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, Integer.valueOf(itemToDelete.getId()));
            pst.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method finds all the items.
     *
     * @return result list
     */
    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM " + TABLE_ITEMS;
            ResultSet resultSet = stmt.executeQuery(sql);
            result = parseItem(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method finds the item by name.
     *
     * @param key ** the item's name**
     * @return resultList
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_ITEMS + " WHERE name=?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, key);
            ResultSet resultSet = pst.executeQuery();
            result = parseItem(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method finds the item by id.
     *
     * @param id the item's id
     * @return resultList
     */
    @Override
    public Item findById(String id) {
        List<Item> result = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_ITEMS + " WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, Integer.valueOf(id));
            ResultSet resultSet = pst.executeQuery(sql);
            result = parseItem(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public void close() throws Exception {
        connection.close();

    }

    /**
     * method to connect to sql and read configurations.
     *
     * @return true if the connection is done and table exists or was created
     */
    public boolean init() {
        boolean success = true;
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            if (checkDataBase()) {
                success = createTable();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null && success;
    }

    /**
     * method to to check if table already exists, if not then create
     */
    private boolean checkDataBase() {
        DatabaseMetaData meta = null;
        boolean exist = false;
        try {
            meta = connection.getMetaData();
            ResultSet res = meta.getTables(null, null, TABLE_ITEMS, null);
            if (res.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    private boolean createTable() {
        boolean success = false;
        try (Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE " + TABLE_ITEMS
                    + "(id INTEGER not NULL, "
                    + " name VARCHAR(255), "
                    + " description VARCHAR(255), "
                    + " created_on TIMESTAMP NOT NULL, "
                    + " PRIMARY KEY ( id ));";
            stmt.executeUpdate(sql);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;

    }

    /**
     * method to map database table rows to item object
     */
    private List<Item> parseItem(ResultSet resultSet) throws SQLException {
        List<Item> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            long create = 0;
            try {
                create = sdf.parse(resultSet.getString("created_on")).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Item item = new Item(name, description, create);
            item.setId(id);
            result.add(item);
        }
        return result;
    }

}
