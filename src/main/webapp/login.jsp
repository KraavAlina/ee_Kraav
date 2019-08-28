<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp" %>

<div class="container">
  <div class="row">
    <div class="col-4"></div>
    <div class="col-4">
        <h3 class="text-center">Вход</h3>
        <p class="font-weight-light text-center">Войдите или зарегистрируйте новый аккаунт</p>
        <form id="Form" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="login" typeof="text" name="login" class="form-control" placeholder="Login">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" name="password" class="form-control" placeholder="Password" >
          </div>
          <%
              if ((String) request.getAttribute("error") != null) {
                  if (request.getAttribute("error").equals("errorEmptyData"))
                    out.println("<div class='alert alert-warning' role='alert'>" + "Заполните все поля" + "</div>");
                  if (request.getAttribute("error").equals("errorUserIsNot"))
                    out.println("<div class='alert alert-warning' role='alert'>" + "Пользователя с таким логином не существует" + "</div>");
                  if (request.getAttribute("error").equals("errorPassword"))
                    out.println("<div class='alert alert-warning' role='alert'>" + "Пароль неверный" + "</div>");
                  request.setAttribute("error", null);
              }
          %>
          <button type="submit" class="mr-4 btn btn-primary">Войти</button>
        </form>
    </div>
    <div class="col-4"></div>
  </div>
</div>

<%@include file="default/footer.jsp" %>