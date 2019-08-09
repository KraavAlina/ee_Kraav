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
        <h3 class="text-center"></br></br></br>Регистрация</h3>
        <p class="font-weight-light text-center"></p>
        </p>
        <form id="Form" action="main" method="POST">
          <div class="form-group">
            <input type="name" typeof="text" name="name" class="form-control"  placeholder="ФИО">
          </div>
          <div class="form-group">
            <input type="address" typeof="text" name="address" class="form-control" placeholder="Адрес проживания">
          </div>
          <div class="form-group">
             <input id="phone" type="text" class="form-control input-medium bfh-phone" data-format="+7 (ddd) ddd-dddd">
          </div>
          <div class="form-group">
            <input type="login" name="login" class="form-control" placeholder="Логин">
          </div>
           <div class="form-group">
              <input type="password1" name="password1" class="form-control" placeholder="Пароль">
           </div>
           <div class="form-group">
                 <input type="password2" name="password2" class="form-control" placeholder="Повторите пароль">
           </div>
          <button type="submit" class="mr-4 btn btn-primary">Зарегистрироваться</button>
        </form>
    </div>
    <div class="col-4"></div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.3.4/inputmask/inputmask.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.3.4/inputmask/jquery.inputmask.js"></script>
<script>
    $("#phone").inputmask({"mask":"+7 (999) 999-9999"});
</script>
    </body>
</html>