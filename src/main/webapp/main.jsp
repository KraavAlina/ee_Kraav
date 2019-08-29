<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp" %>

<%
    List<FlowerEntity> flowersList = (ArrayList<FlowerEntity>) request.getAttribute("flowersList");
    List<FlowerEntity> searchedFlower = (ArrayList<FlowerEntity>) request.getAttribute("flowersFoundList");
%>


<div class="container">
  <div class="row">
    <div class="col-2">
    <form id="Form2" action = "/main" method="POST">
    <div class="form-group">
        Поиск по названию:
        <input type="text" name="searchedName" class="form-control">
    </div>
        <button type="mr-4 button" name="searchName" value="check" class="btn btn-outline-info">Поиск</button>
    </form>
    <form id="Form3" action = "/main" method="POST">
        <div class="form-group">
            Ценовой диапазон:
            от: <input type="number" name="searchedPriceFrom" class="form-control" min="0">
            до: <input type="number" name="searchedPriceTo" class="form-control" min="1">
        </div>
            <button type="mr-4 button" name="searchPrice" value="check" class="btn btn-outline-info">Поиск</button>
    </form>
    </div>
    <div class="col-8">
        <% if (!(searchedFlower != null && searchedFlower.isEmpty())) { %>
        <table class="table table-hover table-dark">
          <thead>
            <tr>
              <th scope="col">Название</th>
              <th scope="col">Цена</th>
              <th scope="col">Количество на складе</th>
              <th scope="col">Изображение</th>
              <th scope="col">Кол-во</th>
            </tr>
          </thead>
          <% } %>
          <tbody>
          <% if (searchedFlower == null) { %>
          <% if(flowersList != null && !flowersList.isEmpty()) { %>
            <% for (FlowerEntity flower : flowersList) { %>
            <tr>
              <th scope="row"><%= flower.getName() %></th>
              <td><%= flower.getPrice() %></td>
              <td><%= flower.getCount() %></td>
              <td><img src='<%= flower.getImage() %>' /></td>
              <td style="width: 100px;">
                <input type="number" form="Form" name="<%= flower.getId() %>" class="form-control" min="0" max="<%= flower.getCount() %>">
              </td>
            </tr>
            <% }}} else { %>
            <% if (searchedFlower.isEmpty()) { %>
                <h4 class="text-center">По вашему запросу ничего не найдено.</h4>
            <% request.removeAttribute("flowersFoundList");  %>
            <% } else { %>
                <% for (FlowerEntity flower : searchedFlower) { %>
                   <tr>
                   <th scope="row"><%= flower.getName() %></th>
                   <td><%= flower.getPrice() %></td>
                   <td><%= flower.getCount() %></td>
                   <td><img src='<%= flower.getImage() %>' /></td>
                   <td style="width: 100px;">
                   <input type="number" form="Form" name="<%= flower.getId() %>" class="form-control" min="0" max="<%= flower.getCount() %>">
                   </td>
                </tr>
            <% }}} %>
          </tbody>
        </table>
    </div>
    <div class="col">
    <form id="Form" action = "/main" method="POST">
        <% if (searchedFlower == null || !searchedFlower.isEmpty()) { %>
            <button type="mr-4 button" name="order" value="check" class="btn btn-success btn-lg btn-block">Заказать</button>
        <% } %>
    </form>
    </div>
  </div>
</div>




<%@include file="default/footer.jsp" %>
