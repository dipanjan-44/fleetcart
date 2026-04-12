package com.fleetcart.dao;

import com.fleetcart.model.Driver;
import com.fleetcart.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {

    public static void addDriver(
            String name,
            String phone,
            String status
    ) {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO drivers (name, phone, status) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, status);

            ps.executeUpdate();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static List<Driver> getAllDrivers() {

        List<Driver> drivers =
                new ArrayList<>();

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM drivers";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Driver driver =
                        new Driver();

                driver.setId(
                        rs.getInt("id")
                );

                driver.setName(
                        rs.getString("name")
                );

                driver.setPhone(
                        rs.getString("phone")
                );

                driver.setStatus(
                        rs.getString("status")
                );

                drivers.add(driver);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return drivers;

    }

    public static int getTotalDrivers() {

    int count = 0;

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "SELECT COUNT(*) FROM drivers";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            count =
                    rs.getInt(1);

        }

    }

    catch (Exception e) {

        e.printStackTrace();

    }

    return count;

}

}