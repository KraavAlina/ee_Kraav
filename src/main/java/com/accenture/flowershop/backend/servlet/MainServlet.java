package com.accenture.flowershop.backend.servlet;

import com.accenture.flowershop.backend.entity.Flower;
import com.accenture.flowershop.backend.repository.FlowerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(request.getAttribute("Hello"));
        response.getWriter().println(request.getParameter("login"));
        response.getWriter().println("doGet MainServlet");
        String jspName = "main.jsp";
        request.getRequestDispatcher(jspName).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspName;
        String error = "empty_date";
        if (request.getParameter("login").isEmpty() || request.getParameter("password").isEmpty()) {
            response.sendRedirect("/?error= "+ error);
        } else {
            String login = request.getParameter("login");
            request.setAttribute("login", login);
            jspName = "main.jsp";
            request.getRequestDispatcher(jspName).forward(request, response);
        }
    }
}