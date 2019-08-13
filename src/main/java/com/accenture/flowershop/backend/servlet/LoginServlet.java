package com.accenture.flowershop.backend.servlet;

import com.accenture.flowershop.backend.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
       // request.setAttribute("error", null);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspName;
        String errorEmptyData = "empty_data";
        if (request.getParameter("login").isEmpty() || request.getParameter("password").isEmpty()) {
            request.setAttribute("errorEmptyData", errorEmptyData);
            jspName = "login.jsp";
            request.getRequestDispatcher(jspName).forward(request, response);
        } else {
            String login = request.getParameter("login");
            request.setAttribute("login", login);
            jspName = "main.jsp";
            request.getRequestDispatcher(jspName).forward(request, response);
        }
    }
    public String login (String user, String password) {return null;}
    public User register (String user, String password, String address) {return null;}
}
