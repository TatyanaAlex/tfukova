package ru.job4j.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSql implements AutoCloseable {

    private final Config config;
    private Connection connect;

    public StoreSql(Config config, Connection connection) {
        this.config = config;
        this.connect = connection;
    }

    // генерирует n записей в бд
    public void generate(int size) {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS entry (id integer PRIMARY KEY);";
        String sqlInsertRows = "INSERT INTO entry (id) VALUES (?)";
        try {
            Statement stmt = connect.createStatement();
            // create a new table
            stmt.execute(sql);
            connect.commit();
            deleteIfNotEmpty("entry");
            PreparedStatement pstm = connect.prepareStatement(sqlInsertRows);
            for (int i = 0; i < size; i++) {
                pstm.setInt(1, i);
                pstm.addBatch();
            }
            pstm.executeBatch();
            connect.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    public List<Entry> load() {
        List<Entry> resultList = new ArrayList<>();
        String sql = "SELECT * FROM entry";
        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            connect.commit();
            while (rs.next()) {
                resultList.add(new Entry(rs.getInt("id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return resultList;
    }

    private void deleteIfNotEmpty(String tableName) {
        String sql = "DELETE * FROM " + tableName;
        try {
            Statement stmt = connect.createStatement();
            stmt.execute(sql);
            connect.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connect != null) {
                    connect.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

}
