package com.fleetcart.servlet;

import com.fleetcart.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/create-order")
public class OrderServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {

        String customerName =
                request.getParameter("customerName");

        String pickupLocation =
                request.getParameter("pickupLocation");

        String deliveryLocation =
                request.getParameter("deliveryLocation");

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO orders (customer_name, pickup_location, delivery_location, status) VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, customerName);
            ps.setString(2, pickupLocation);
            ps.setString(3, deliveryLocation);
            ps.setString(4, "Pending");

            ps.executeUpdate();

            response.sendRedirect(
                    "dashboard.jsp"
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}