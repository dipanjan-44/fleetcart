package com.fleetcart.servlet;

import com.fleetcart.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/update-status")
public class UpdateStatusServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {

        String orderId =
                request.getParameter("orderId");

        String status =
                request.getParameter("status");

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE orders SET status=? WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, status);

            ps.setInt(2,
                    Integer.parseInt(orderId));

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