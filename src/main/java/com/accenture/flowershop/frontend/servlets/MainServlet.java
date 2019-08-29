package com.accenture.flowershop.frontend.servlets;

import com.accenture.flowershop.backend.entity.FlowerEntity;
import com.accenture.flowershop.backend.entity.FlowersInOrderEntity;
import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import com.accenture.flowershop.backend.services.FlowerService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

    @Autowired
    private FlowerService flowerService;

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

        String jspName = "/main.jsp";

        if (session == null) {
            response.sendRedirect("/login");
        } else {
            UserEntity userData = (UserEntity) session.getAttribute("user");
            if (userData == null) {
                response.sendRedirect("/login");
            } else {
                request.setAttribute("flowersList", flowerService.getAllFlowers());
                RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
                dispatcher.forward(request, response);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);

        String jspName = "/main.jsp";

        String logout = request.getParameter("logout");
        String cart = request.getParameter("order");
        String searchName = request.getParameter("searchName");
        String searchPrice = request.getParameter("searchPrice");

        // Если нажата кнопка выхода, закрываем сессию и переходим в начало
        if (logout != null && !logout.isEmpty() ) {
            if (session != null) {
                session.removeAttribute("user");
                session.removeAttribute("flowersOfOrder");
                response.sendRedirect("/login");
            } else {
                response.sendRedirect("/login");
            }
        }
        else {
        /*
           Если был вызван заказ, сравниваем имена полученных атрибутов с id существующих цветов
           Если такой цветок есть и он был выбран, добавляем в список полученных цветов
        */
            if (cart != null && !cart.isEmpty()) {

                Map<Long, String> receivedFlowerIdMap = new HashMap<>();
                List<FlowerEntity> allFlowers = flowerService.getAllFlowers();
                for (FlowerEntity flower : allFlowers) {
                    String countFlowers = (String) request.getParameter(flower.getId().toString());
                    if (countFlowers != null && !countFlowers.equals("0") && !countFlowers.equals("")) {
                        receivedFlowerIdMap.put(flower.getId(), countFlowers);
                    }
                }

                UserEntity owner = (UserEntity) session.getAttribute("user");
                OrderEntity newOrder = orderService.createOrder(owner, receivedFlowerIdMap);
                List<FlowersInOrderEntity> flowersOfOrder = newOrder.getFlowersData();

                /* В сессию кладем заказ "cart", список цветов в заказе в формате FO,
                удаляем заказ из request
                * */
                session.setAttribute("cart", newOrder);
                session.setAttribute("flowersOfOrder", flowersOfOrder);
                request.removeAttribute("order");
            }

            // Если был вызван поиск по имени
            if (searchName != null && !searchName.isEmpty()) {
                String searchedName = request.getParameter("searchedName");
                if (searchedName != null && !searchedName.isEmpty()) {
                    List<FlowerEntity> searchedFlower = flowerService.findFlowerByName(searchedName);
                    request.setAttribute("flowersFoundList", searchedFlower);
                    request.removeAttribute("searchName");
                }
            }

            // Если был вызван поиск по цене
            if (searchPrice != null && !searchPrice.isEmpty()) {
                String priceFrom = request.getParameter("searchedPriceFrom");
                String priceTo = request.getParameter("searchedPriceTo");
                if (priceFrom != null && !priceFrom.isEmpty() ||
                        priceTo != null && !priceTo.isEmpty()) {
                    List<FlowerEntity> searchedFlower = flowerService.findFlowersByPrice(priceFrom, priceTo);
                    request.setAttribute("flowersFoundList", searchedFlower);
                    request.removeAttribute("searchedPriceFrom");
                    request.removeAttribute("searchedPriceTo");
                }
            }

            request.setAttribute("flowersList", flowerService.getAllFlowers());
            RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
            dispatcher.forward(request, response);
        }
    }
}




