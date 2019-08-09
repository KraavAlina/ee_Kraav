package com.accenture.flowershop.backend.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("doGet MainServlet");
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Hello", "мир" );
        request.getRequestDispatcher("/login").forward(request, response);
    }
}