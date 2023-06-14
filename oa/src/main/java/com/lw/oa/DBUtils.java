package com.lw.oa;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private static String driver = bundle.getString("driver");
    private static String username = bundle.getString("username");
    private static String password = bundle.getString("password");
    private static String url = bundle.getString("url");
    static {
        try {
            Class.forName(driver);
            System.out.println("class for name");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        System.out.println("before get");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void close(Connection connection, ResultSet resultSet, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
