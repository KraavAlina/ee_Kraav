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
import java.io.IOException;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationServlet  extends HttpServlet {

    @Autowired
    private UserService userService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspName = "/registration.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jspName = "/registration.jsp";
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String login = request.getParameter("login");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || login.isEmpty() || password1.isEmpty()) {
            request.setAttribute("error", "errorEmptyDataRegistration");
        }
        else {
            if (!password1.equals(password2)) {
                request.setAttribute("error", "errorEqualsPass");
            }
            else {
                UserEntity userEntity = new UserEntity(login, password1, name, address, phone);
                UserEntity returnUser = userService.registration(userEntity);
                if (returnUser == null){
                    request.setAttribute("error", "errorLoginBusy");
                }
            }
        }

        if (request.getAttribute("error") == null) {
            response.sendRedirect("/login");

        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(jspName);
            requestDispatcher.forward(request, response);
        }
    }
}
