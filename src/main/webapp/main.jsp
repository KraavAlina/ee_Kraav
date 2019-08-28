<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp" %>

<%
    List<FlowerEntity> flowersList = (ArrayList<FlowerEntity>) request.getAttribute("flowersList");
%>


<div class="container">
  <div class="row">
    <div class="col-2">
    <form id="Form" action = "/main" method="POST">
    <div class="form-group">
        <label for="exampleInputEmail1"> Поиск по названию: </label>
        <input type="searchedName" typeof="text" name="searchedName" class="form-control">
    </div>
        <button type="mr-4 button" name="searchName" value="check" class="btn btn-outline-info">Поиск</button>
    </form>
    </div>
    <div class="col-8">
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
          <tbody>
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
            <% }} %>
          </tbody>
        </table>
    </div>
    <div class="col"></br>
       <form id="Form" action = "/main" method="POST">
            <button type="mr-4 button" name="order" value="check" class="btn btn-success btn-lg btn-block">Заказать</button>
       </form>
    </div>
  </div>
</div>

<%@include file="default/footer.jsp" %>
