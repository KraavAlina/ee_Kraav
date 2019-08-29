<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp" %>

<%
    OrderEntity createdOrder = (OrderEntity) session.getAttribute("cart");
    List<FlowersInOrderEntity> flowersOfOrder = (List<FlowersInOrderEntity>) session.getAttribute("flowersOfOrder");
    List<OrderEntity> savedOrders = (List<OrderEntity>) request.getAttribute("savedOrder");
%>


<% if (flowersOfOrder != null && !flowersOfOrder.isEmpty()) { %>
<div class="container">
  <div class="row">
    <div class="col-2">
    <h4>Корзина: </h4>
    </div>
    <div class="col-8">
        <table class="table table-hover table-dark">
          <thead>
            <tr>
              <th scope="col">Цветок</th>
              <th scope="col">Количество</th>
              <th scope="col">Стоимость</th>
            </tr>
          </thead>
          <tbody>
            <% for (FlowersInOrderEntity flowerInOrder : flowersOfOrder) { %>
            <tr>
              <th scope="row"><%= flowerInOrder.getFlower().getName() %></th>
              <td><%= flowerInOrder.getCount() %></td>
              <td><%= flowerInOrder.getPricePerFlower() %></td>
            </tr>
            <% } %>
          </tbody>
        </table>
    </div>
    <div class="col">
       <p><h6> Итого: <%= createdOrder.getFullPrice() %>р </h6></p>
       <font color="#008000"><h6> Цена со скидкой: </h6><h6> <%= createdOrder.getDiscountPrice() %>р </h6></font>
       <form id="Form" action = "/cart" method="POST">
            <button type="mr-4 button" name="createOrder" value="check" class="btn btn-success">Создать заказ</button>
       </form>
       <% if ((String) request.getAttribute("error") != null) {
            if (request.getAttribute("error").equals("notEnoughMoney"))
                out.println("<div class='alert alert-danger' role='alert'>" + "На балансе недостаточно средств" + "</div>");
            request.setAttribute("error", null);
       } %>
    </div>
  </div>
</div>
<% } else { %>
   <h3 class="text-center"> В корзине пока ничего нет. </h3>
<% } %>



<% if (savedOrders != null && !savedOrders.isEmpty()) {  %>
</br><h4 class="text-center">Сохраненные заказы </h4>
<div class="container">
  <div class="row">
    <% for (OrderEntity order :  savedOrders) { %>
        <% if (!order.getStatus().equals(OrderStatus.CLOSED)) {%>
    <div class="col-2"></div>
    <div class="col-8">
        <p><h5>Код заказа: <%= order.getId() %>
        <% if (order.getStatus().equals(OrderStatus.PAID)) { %>
             <font color="#008000"> (Оплачено: <%= order.getDiscountPrice() %>р )</font>
        <% } %>
        </h5></p>
            <table class="table table-hover table-dark">
                <thead>
                <tr>
                    <th scope="col">Цветок</th>
                    <th scope="col">Количество</th>
                    <th scope="col">Стоимость</th>
                </tr>
                </thead>
            <tbody>
            <% flowersOfOrder = order.getFlowersData();
                for (FlowersInOrderEntity flowerInOrder : flowersOfOrder) { %>
                <tr>
                    <th scope="row"><%= flowerInOrder.getFlower().getName() %></th>
                    <td><%= flowerInOrder.getCount() %></td>
                    <td><%= flowerInOrder.getPricePerFlower() %></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </div>
    <div class="col">
        <% if (!order.getStatus().equals(OrderStatus.PAID)) { %>
        </br>
           <p><h5> Итого: <%= order.getFullPrice() %></h5></p>
           <font color="#008000"><h5> Цена со скидкой: <%= order.getDiscountPrice() %></h5></font>
           <form id="Form" action = "/cart" method="POST">
                <button type="mr-4 button" name="<%= order.getId() %>" value="check" class="btn btn-success">Оплатить</button>
           </form>
           <% if ((String) request.getAttribute("error" + order.getId()) != null) {
                if (request.getAttribute("error" + order.getId()).equals("notEnoughMoney"))
                    out.println("<div class='alert alert-danger' role='alert'>" + "На балансе недостаточно средств" + "</div>");
                request.setAttribute("error" + order.getId(), null);
           } %>
         <% } %>
    </div>
    <% } } %>
  </div>
</div>
<% } %>


