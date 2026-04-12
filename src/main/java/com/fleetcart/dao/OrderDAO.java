package com.fleetcart.dao;

import com.fleetcart.model.Order;
import com.fleetcart.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static List<Order> getAllOrders() {

        List<Order> orders =
                new ArrayList<>();

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM orders ORDER BY id DESC";

            Statement stmt =
                    conn.createStatement();

            ResultSet rs =
                    stmt.executeQuery(sql);

            while (rs.next()) {

                Order order =
                        new Order();

                order.setId(
                        rs.getInt("id")
                );

                order.setCustomerName(
                        rs.getString("customer_name")
                );

                order.setPickupLocation(
                        rs.getString("pickup_location")
                );

                order.setDeliveryLocation(
                        rs.getString("delivery_location")
                );

                order.setStatus(
                        rs.getString("status")
                );

                order.setCreatedAt(
                        rs.getString("created_at")
                );

                orders.add(order);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return orders;

    }
    public static int getTotalOrders() {

    int count = 0;

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "SELECT COUNT(*) FROM orders";

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

public static int getPendingOrders() {

    int count = 0;

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
                "SELECT COUNT(*) FROM orders WHERE status='Pending'";

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