<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.accenture.flowershop.backend.entity.UserEntity" %>
<%@ page import="com.accenture.flowershop.backend.entity.FlowerEntity" %>
<%@ page import="com.accenture.flowershop.backend.entity.OrderEntity" %>
<%@ page import="com.accenture.flowershop.backend.entity.FlowersInOrderEntity" %>
<%@ page import="com.accenture.flowershop.backend.enums.OrderStatus" %>
<%@ page import="java.lang.String" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedList" %>


<html>
    <head>
        <meta charset="utf-8">
        <%
              HttpServletRequest httpReq = (HttpServletRequest)request;
              String url = httpReq.getRequestURL().toString();
              UserEntity userData = (UserEntity) session.getAttribute("user");
              boolean loginPage = url.equals("http://localhost:8080/login.jsp");
              boolean mainPage = url.equals("http://localhost:8080/main.jsp");
              boolean registrationPage = url.equals("http://localhost:8080/registration.jsp");
              boolean cartPage = url.equals("http://localhost:8080/cart.jsp");
              boolean adminPage = url.equals("http://localhost:8080/admin.jsp");
              if ( loginPage ) {
        %>
            <title>Login</title>
        <% } %>
        <% if ( mainPage ) { %>
            <title>Denerica</title>
        <% } %>
        <% if ( registrationPage ) { %>
            <title>Registration</title>
        <% } %>
        <% if ( cartPage ) { %>
             <title>Your orders</title>
        <% } %>
        <% if ( adminPage ) { %>
             <title>Admin</title>
        <% } %>
        <link rel="stylesheet" href="/static/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="/static/css/styles.css">
    </head>
<body>


<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
<% if (request.getSession(false) == null) { %>
  <a class="navbar-brand" href="">Denerica</a>
  <% } else {%>
   <a class="navbar-brand" href="/main">Denerica</a>
  <%}%>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

<% if ( mainPage ) { %>
  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <span class="nav-link disabled" style="color:#00FA9A">Привет, <%= userData.getFullName() %>! </span>
      </li>
      <li class="nav-item">
        <span class="nav-link" href="">Баланс: <%= userData.getBalance() %>р </span >
      </li>
      <li class="nav-item">
        <span  class="nav-link disabled" href="">Скидка: <%= userData.getDiscount() %>% </span >
      </li>
    </ul>
    <a href="/cart" method="POST" class="mr-4 btn btn-info"> Корзина </a>
    <form class="form-inline my-2 my-lg-0" method="POST" action="/main">
      <button class="btn btn-secondary my-2 my-sm-0" name="logout" value="ok" type="submit">Выйти</button>
    </form>
  </div>
 <% } %>

<% if ( loginPage ) { %>
 <div class="collapse navbar-collapse" id="navbarsExampleDefault">
  <ul class="navbar-nav mr-auto"> </ul>
    <form class="form-inline my-2 my-lg-0">
        <a href="/registration" method="POST" class="btn btn-link my-2 my-sm-0">Регистрация</a>
    </form>
 </div>
<% } %>

<% if ( registrationPage ) { %>
 <div class="collapse navbar-collapse" id="navbarsExampleDefault">
  <ul class="navbar-nav mr-auto"> </ul>
    <form class="form-inline my-2 my-lg-0">
        <a href="/login" method="POST" class="btn btn-secondary my-2 my-sm-0">Войти</a>
    </form>
 </div>
<% } %>

<% if ( cartPage ) { %>
  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <span class="nav-link" href="">Баланс: <%= userData.getBalance() %>р </span >
      </li>
      <li class="nav-item">
        <span  class="nav-link disabled" href="">Скидка: <%= userData.getDiscount() %>% </span >
      </li>
    </ul>
    <a href="/main" method="POST" class="mr-4 btn btn-info"> Вернуться на главную страницу </a>
    <form class="form-inline my-2 my-lg-0" method="POST" action="/main">
      <button class="btn btn-secondary my-2 my-sm-0" name="logout" value="ok" type="submit">Выйти</button>
    </form>
  </div>
 <% } %>

<% if ( adminPage ) { %>
  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <span class="nav-link disabled" style="color:#00FA9A">Привет, Админ! </span>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" method="POST" action="/main">
      <button class="btn btn-secondary my-2 my-sm-0" name="logout" value="ok" type="submit">Выйти</button>
    </form>
  </div>
 <% } %>

</nav>

</br></br></br></br></br>