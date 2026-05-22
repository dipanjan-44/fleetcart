package com.fleetcart.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://host.docker.internal:3307/fleetcart?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

                String username = "root";

                String password = "root";

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