package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
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

    /**
     * Method adds new item.
     *
     * @param item **created item**
     * @return item
     */
    @Override
    public Item add(Item item) {
        item.setId(String.valueOf(RANDOM.nextInt()));
        try {
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO " + TABLE_ITEMS
                    + "(name, description, created_on) "
                    + "VALUES(" + item.getName() + "," + item.getDescription() + "," + item.getCreate() + ")";
            stmt.execute(sql);
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
        try {
            Statement stmt = connection.createStatement();
            String sql = "UPDATE " + TABLE_ITEMS
                    + " SET name=" + itemToUpdate.getName()
                    + ", description=" + itemToUpdate.getDescription()
                    + ", created_on=" + itemToUpdate.getCreate()
                    + "WHERE id=" + itemToUpdate.getId();
            stmt.execute(sql);
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
        try {
            Statement stmt = connection.createStatement();
            String sql = "DELETE " + TABLE_ITEMS
                    + "WHERE id=" + itemToDelete.getId();
            stmt.execute(sql);
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
        try {
            Statement stmt = connection.createStatement();
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
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT " + TABLE_ITEMS
                    + "WHERE name=" + key;
            ResultSet resultSet = stmt.executeQuery(sql);
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
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT " + TABLE_ITEMS
                    + "WHERE id=" + id;
            ResultSet resultSet = stmt.executeQuery(sql);
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
        try {
            Statement stmt = connection.createStatement();
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
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            long create = resultSet.getLong("created_on");
            Item item = new Item(name, description, create);
            item.setId(id);
            result.add(item);
        }
        return result;
    }

}
