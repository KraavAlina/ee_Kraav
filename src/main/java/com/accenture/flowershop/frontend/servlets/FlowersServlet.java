package com.accenture.flowershop.frontend.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/catalog")
public class FlowersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String param = (String) request.getSession().getAttribute("parameter");
    }
}