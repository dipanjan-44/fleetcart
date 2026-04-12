package com.fleetcart.servlet;

import com.fleetcart.dao.DriverDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/add-driver")
public class AddDriverServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String phone =
                request.getParameter("phone");

        String status =
                request.getParameter("status");

        DriverDAO.addDriver(
                name,
                phone,
                status
        );

        response.sendRedirect(
                "drivers.jsp"
        );

    }

}