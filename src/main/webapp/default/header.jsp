<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <%
              HttpServletRequest httpReq = (HttpServletRequest)request;
              String url = httpReq.getRequestURL().toString();
              boolean loginPage = url.equals("http://localhost:8080/login.jsp");
              boolean mainPage = url.equals("http://localhost:8080/main.jsp");
              boolean registrationPage = url.equals("http://localhost:8080/registration.jsp");
              if ( loginPage ) {
        %>
            <title>Login</title>
        <% } %>
        <% if ( mainPage ) { %>
            <title>DENERICA</title>
        <% } %>
        <% if ( registrationPage) { %>
            <title>Registration</title>
        <% } %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
<body>

<% if ( mainPage ) { %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">Denerica</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Корзина <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Баланс: </a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Скидка: </a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Выйти</button>
    </form>
  </div>
</nav>
<% } %>
<div>
</div>

