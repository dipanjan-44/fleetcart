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

            System.out.println("REGISTER REQUEST:");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement(
                "INSERT INTO users (username, password, role) VALUES (?, ?, ?)");

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, "USER");

            int rows =
                ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            response.sendRedirect(
                "login.jsp?registered=true");

        }

        catch (Exception e) {

            System.out.println("REGISTRATION ERROR:");
            e.printStackTrace();

            response.sendRedirect(
                "signup.jsp?error=true");

        }

    }

}