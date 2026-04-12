package com.fleetcart.servlet;

import com.fleetcart.util.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/test-db")
public class TestDBServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        try {

            Connection conn =
                    DBConnection.getConnection();

            if (conn != null) {

                out.println(
                        "<h2>Database Connected Successfully</h2>"
                );

            }

            else {

                out.println(
                        "<h2>Database Connection Failed</h2>"
                );

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}