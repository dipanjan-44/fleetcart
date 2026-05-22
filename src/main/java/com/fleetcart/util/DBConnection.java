package com.fleetcart.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = System.getenv("DB_URL");
                String username = System.getenv("DB_USERNAME");
                String password = System.getenv("DB_PASSWORD");

                connection = DriverManager.getConnection(
                        url,
                        username,
                        password
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}