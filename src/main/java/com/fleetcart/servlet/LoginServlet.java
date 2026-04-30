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

            String password =
                    request.getParameter("password");

            // Simple login check
            if ("admin".equals(username)
                    && "admin".equals(password)) {

                response.sendRedirect(
                        "dashboard.jsp");

            }
            else {

                response.sendRedirect(
                        "login.jsp?error=true");

            }

        }
        catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "login.jsp?error=true");

        }

    }

}