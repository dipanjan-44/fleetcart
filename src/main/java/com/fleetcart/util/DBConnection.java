package com.fleetcart.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database configuration for Docker environment
    private static final String URL =
            "jdbc:mysql://fleetcart-mysql:3306/fleetcart"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully.");

        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }

        return conn;
    }
}