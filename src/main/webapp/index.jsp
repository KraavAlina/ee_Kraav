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
    <div class="col-4"></div>
    <div class="col-4">
        <h3 class="text-center"></br></br></br>Вход</h3>
        <p class="font-weight-light text-center">Войдите или зарегистрируйте новый аккаунт</p>
        </p>
        <form id="Form" action="main" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Логин</label>
            <input type="login" typeof="text" name="login" class="form-control" placeholder="Пожалуйста, введите свой логин">
             <c:forEach items="${items}" var="iterator" varStatus="rowStatus">
                <div> <label>${iterator.id}</label><label>${iterator.name1}</label> </div>
            <c:forEach>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Пароль</label>
            <input type="password" name="password" class="form-control" >
          </div>
          <button type="submit" class="mr-4 btn btn-primary">Войти</button>
          <a href="/registration" action="action" method="POST" class="btn btn-link">Создать аккаунт</a>
        </form>
    </div>
    <div class="col-4"></div>
  </div>
</div>

    </body>
</html>