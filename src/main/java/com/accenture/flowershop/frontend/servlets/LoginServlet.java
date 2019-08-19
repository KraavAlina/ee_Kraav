package com.accenture.flowershop.frontend.servlets;

import com.accenture.flowershop.backend.services.FlowerService;
import com.accenture.flowershop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/login"})
public class LoginServlet  extends HttpServlet {
    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String error = "errorEmptyData";
        if (login.isEmpty() || password.isEmpty()) {
            request.setAttribute(error, "errorEmptyData");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
