package com.fleetcart.servlet;

import com.fleetcart.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delete-order")
public class DeleteOrderServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {

        String orderId =
                request.getParameter("orderId");

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM orders WHERE id=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(
                    1,
                    Integer.parseInt(orderId)
            );

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