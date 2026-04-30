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
                "SELECT * FROM users WHERE username=? AND password=?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                ps.executeQuery();

            if (rs.next()) {

                status = true;
                System.out.println("Login successful");

            }else{
                System.out.println("Login failed");
            }

        }
        catch (Exception e) {

            e.printStackTrace();

        }

        return status;

    }

}