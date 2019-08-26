package com.accenture.flowershop.frontend.servlets;

import com.accenture.flowershop.backend.entity.UserEntity;
import com.accenture.flowershop.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/login"})
public class LoginServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nameJsp = "/login.jsp";

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserEntity userEntity = new UserEntity(login, password);
        UserEntity returnUser = null;
        if (login.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "errorEmptyData");
        } else {
            returnUser = userService.login(userEntity);
            if (returnUser == null) {
                request.setAttribute("error", "errorUserIsNot");
            } else {
                if (!returnUser.getPassword().equals(password)) {
                    request.setAttribute("error", "errorPassword");
                }
            }
        }
        if (request.getAttribute("error") == null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", returnUser);
            session.setMaxInactiveInterval(30*60);
            if (login.equals("admin"))
                response.sendRedirect("/admin");
            else
                response.sendRedirect("/main");
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(nameJsp);
            requestDispatcher.forward(request, response);
        }
    }
}
