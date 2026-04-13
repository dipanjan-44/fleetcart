package com.fleetcart.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3307/fleetcart?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "root"; // change if needed

    public static Connection getConnection() {
        Connection conn = null;

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://fleetcart-mysql:3306/fleetcart";
                String username = "root";
                String password = "root";

                conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
                e.printStackTrace();
        }

        return conn;
        }

}