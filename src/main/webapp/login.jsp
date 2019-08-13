<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.String" %>

<%@include file="default/header.jsp" %>

<div class="container">
  <div class="row">
    <div class="col-4"></div>
    <div class="col-4">
        <h3 class="text-center"></br></br></br>Вход</h3>
        <p class="font-weight-light text-center">Войдите или зарегистрируйте новый аккаунт</p>
        </p>
        <form id="Form" action="login" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="login" typeof="text" name="login" class="form-control" placeholder="Введите логин">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" name="password" class="form-control" placeholder="Пароль" >
          </div>
          <%
              if ((String) request.getAttribute("errorEmptyData") != null) {
                  String error = (String) request.getAttribute("errorEmptyData");
                  out.println("<div class='alert alert-warning' role='alert'>" + "Заполните все поля!" + "</div>");
              }
          %>
          <button type="submit" class="mr-4 btn btn-primary">Войти</button>
          <a href="/registration" method="POST" class="btn btn-link">Создать аккаунт</a>
        </form>
    </div>
    <div class="col-4"></div>
  </div>
</div>

<%@include file="default/footer.jsp" %>