<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp" %>


<%
    List<OrderEntity> ordersList = (ArrayList<OrderEntity>) request.getAttribute("ordersList");
%>


<% if (ordersList != null && !ordersList.isEmpty()) { %>
<div class="container">
  <div class="row">
    <div class="col-2">
    </div>
    <div class="col-8">
        <table class="table table-hover table-dark">
          <thead>
            <tr>
              <th scope="col">Номер заказа</th>
              <th scope="col">Дата создания</th>
              <th scope="col">Дата закрытия</th>
              <th scope="col">Статус</th>
            </tr>
          </thead>
          <tbody>
            <% for (OrderEntity order : ordersList) { %>
            <tr>
              <th scope="row"><%= order.getId() %></th>
              <td><%= order.getDateCreation() %></td>
              <td><%= order.getDateClosing() %></td>
              <td><%= order.getStatus() %></td>
              <% if (order.getStatus().equals(OrderStatus.PAID)) {%>
              <td>
                <form id="Form" action = "/admin" method="POST">
                    <button type="mr-4 button" form="Form" name="<%= order.getId() %>" value="check" class="btn btn-outline-secondary btn-sm">Закрыть заказ</button>
                </form>
              </td>
              <% } %>
            </tr>
            <% } %>
          </tbody>
        </table>
    </div>
    <div class="col"></div>
  </div>
</div>
<% } %>

<%@include file="default/footer.jsp" %>