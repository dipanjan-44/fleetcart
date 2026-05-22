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

                System.out.println("DB URL: " + url);

                connection = DriverManager.getConnection(
                        url,
                        username,
                        password
                );

                System.out.println("DATABASE CONNECTED SUCCESSFULLY");
            }

        } catch (Exception e) {

            System.out.println("DB CONNECTION FAILED");
            e.printStackTrace();
        }

        return connection;
    }
}