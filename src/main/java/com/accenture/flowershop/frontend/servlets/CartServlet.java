package com.accenture.flowershop.frontend.servlets;


import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import com.accenture.flowershop.backend.services.OrderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

@Transactional
@WebServlet(urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Autowired
    private OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String jspName = "/cart.jsp";

        if (session == null) {
            response.sendRedirect("/login");
        } else {
            UserEntity userData = (UserEntity) session.getAttribute("user");
            if (userData == null) {
                response.sendRedirect("/login");
            } else {
                int sizeOrders = userData.getOrders().size();
                List<OrderEntity> savedOrder = userData.getOrders();
                request.setAttribute("savedOrder", savedOrder);
                RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String jspName = "/cart.jsp";

        UserEntity userData = (UserEntity) session.getAttribute("user");
        OrderEntity createdOrder = (OrderEntity) session.getAttribute("cart");

        List<OrderEntity> savedOrder = userData.getOrders();

        String createOrder = (String) request.getParameter("createOrder");

        List<OrderEntity> allOrderUser = userData.getOrders();
        String payIdOrder = null;
        for (OrderEntity order : allOrderUser) {
            String isOrder = (String) request.getParameter(order.getId().toString());
            if (isOrder != null && !isOrder.equals("0") && !isOrder.equals("")) {
                payIdOrder = order.getId().toString();
            }
        }

        if (session != null) {
            // Оформляем заказ
            if (createOrder != null && !createOrder.isEmpty() ) {
                OrderEntity order = orderService.saveOrder(createdOrder);

                // Если заказ не был сохранен, значит на балансе недостаточно средств
                if (order == null) {
                    request.setAttribute("error", "notEnoughMoney");

                } else {
                    session.removeAttribute("flowersOfOrder");
                    session.removeAttribute("cart");
                }
                request.removeAttribute("createOrder");
            }
            // Оплачиваем заказ
            if (payIdOrder != null && !payIdOrder.isEmpty()){
                OrderEntity order = orderService.payOrder(payIdOrder);

                // Изменение данных в сессии
                userData = order.getOwner();
                savedOrder = userData.getOrders();
                session.setAttribute("user", userData);



            }




            request.setAttribute("savedOrder", savedOrder);
            RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }


}
