package com.accenture.flowershop.backend.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet  extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("doGet RegistrationServlet");
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Hello", "мир" );
        request.getRequestDispatcher("/registration").forward(request, response);
    }
}
