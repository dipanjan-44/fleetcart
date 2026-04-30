package com.fleetcart.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fleetcart.util.DBConnection;

@WebServlet("/delete-driver")
public class DeleteDriverServlet
        extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(
                    request.getParameter(
                    "driverId"));

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                    "DELETE FROM drivers WHERE id=?");

            ps.setInt(1, id);

            ps.executeUpdate();

            response.sendRedirect(
                    "drivers.jsp?success=true");

        }

        catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "drivers.jsp?error=true");

        }

    }

}