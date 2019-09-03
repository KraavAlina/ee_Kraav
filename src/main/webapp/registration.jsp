<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="default/header.jsp" %>

<div class="container">
  <div class="row">
    <div class="col-4"></div>
    <div class="col-4">
        <h3 class="text-center">Регистрация</h3>
        <p class="font-weight-light text-center"></p>
        </p>
        <form id="Form" method="POST">
          <div class="form-group">
            <input type="text" name="name" class="form-control"  placeholder="ФИО">
          </div>
          <div class="form-group">
            <input type="text" name="address" class="form-control" placeholder="Адрес проживания">
          </div>
          <div class="form-group">
             <input id="phone" name="phone" class="form-control input-medium bfh-phone" data-format="+7 (ddd) ddd-dddd" placeholder="Телефон">
          </div>
          <div class="form-group">
            <input class="form-control" id="login" name="login" value="${login}" required/>
            <div class="invalid-feedback"> Логин уже занят</div>
          </div>
           <div class="form-group">
              <input type="password" name="password1" class="form-control" placeholder="Пароль">
           </div>
           <div class="form-group">
               <input type="password" name="password2" class="form-control" placeholder="Повторите пароль">
           </div>
           <%
                if ((String) request.getAttribute("error") != null) {
                    if (request.getAttribute("error").equals("errorEmptyDataRegistration"))
                        out.println("<div class='alert alert-warning' role='alert'>" + "Заполните все поля" + "</div>");
                    if (request.getAttribute("error").equals("errorEqualsPass"))
                        out.println("<div class='alert alert-warning' role='alert'>" + "Пароли не совпадают" + "</div>");
                    //if (request.getAttribute("error").equals("errorLoginBusy"))
                        //out.println("<div class='alert alert-warning' role='alert'>" + "Логин уже занят" + "</div>");
                    request.setAttribute("error", null);
                 }
           %>
          <button id="submit" type="submit" class="mr-4 btn btn-primary">Зарегистрироваться</button>
        </form>
    </div>
    <div class="col-4"></div>
  </div>
</div>


<%@include file="default/footer.jsp" %>