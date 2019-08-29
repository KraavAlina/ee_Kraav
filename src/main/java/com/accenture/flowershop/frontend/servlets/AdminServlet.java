package com.accenture.flowershop.frontend.servlets;

import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.services.OrderService;
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
import java.util.List;

@WebServlet (urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    @Autowired
    private OrderService orderService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String jspName = "/admin.jsp";
        if (session == null) {
            response.sendRedirect("/login");
        } else {
            List<OrderEntity> allSavedOrders = orderService.getAllSavedOrders();
            request.setAttribute("ordersList", allSavedOrders);
            RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String jspName = "/admin.jsp";

        if (session == null) {
            response.sendRedirect("/login");
        } else {
            OrderEntity searchedOrder = null;
            List<OrderEntity> allOrders = orderService.getAllOrders();
            for (OrderEntity order : allOrders) {
                String isOrder = (String) request.getParameter(order.getId().toString());
                if (isOrder != null && !isOrder.equals("")) {
                    searchedOrder = orderService.findById(order.getId());
                }
            }

            OrderEntity closedOrder = orderService.closeOrder(searchedOrder);

            List<OrderEntity> allSavedOrders = orderService.getAllSavedOrders();
            request.setAttribute("ordersList", allSavedOrders);
            RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
            dispatcher.forward(request, response);
        }

    }

}
