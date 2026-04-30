package com.fleetcart.dao;

import java.sql.*;

import com.fleetcart.util.DBConnection;

public class LoginDAO {

    public static boolean validateUser(
            String username,
            String password) {

        boolean status = false;

        try {

            Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(
                "SELECT * FROM users WHERE TRIM(username)=? AND TRIM(password)=?");

            ps.setString(1, username.trim());
            ps.setString(2, password.trim());

            ResultSet rs =
                ps.executeQuery();

            if (rs.next()) {

                System.out.println("LOGIN SUCCESS");

                status = true;

            } else {

                System.out.println("LOGIN FAILED");

            }

        }
        catch (Exception e) {

            e.printStackTrace();

        }

        return status;

    }

}