package com.fleetcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String username =
                    request.getParameter("username");

            // Create session
            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "username",
                    username);

            System.out.println(
                "LOGIN BYPASSED FOR USER: " + username
            );

            // Always go to dashboard
            response.sendRedirect(
                    "dashboard.jsp");

        }
        catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "login.jsp");

        }

    }

}