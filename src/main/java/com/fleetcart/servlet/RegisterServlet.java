package com.fleetcart.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fleetcart.util.DBConnection;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String username =
                request.getParameter("username");

            String password =
                request.getParameter("password");

            Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(
                "INSERT INTO users (username, password, role) VALUES (?, ?, ?)");

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, "USER");

            ps.executeUpdate();

            System.out.println(
                "NEW USER REGISTERED: " + username
            );

            response.sendRedirect(
                "login.jsp");

        }
        catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                "signup.jsp");

        }

    }

}