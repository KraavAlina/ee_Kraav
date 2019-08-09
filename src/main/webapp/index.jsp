<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

<div class="container">
  <div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <h3 class="text-center">Вход</h3>
        <p class="font-weight-light text-center">Войдите или зарегистрируйте новый аккаунт</p>
        </p>
        <form id="Form" action="action" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Логин </label>
            <input type="login" name="param_2" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="введите свой логин">
            <small id="emailHelp" class="form-text text-muted"></small>
             <c:forEach items="${items}" var="iterator" varStatus="rowStatus">
                <div> <label>${iterator.id}</label><label>${iterator.name1}</label> </div>
            <c:forEach>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" class="form-control" id="exampleInputPassword1">
          </div>
            <button type="submit" class="mr-5 btn btn-primary">Войти</button>
            <a href="/registration" class="btn btn-primary">Зарегистрироваться</a>
        </form>
    </div>
    <div class="col-3"></div>
  </div>
</div>

    </body>
</html>