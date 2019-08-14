<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.String" %>

<%@include file="default/header.jsp" %>




<div class="container">
  <div class="row">
    <div class="col-4"></div>
    <div class="col-4">
        <h3 class="text-center"></br></br></br>
        <%
            out.println("<h1>Привет: " + (String) request.getAttribute("login") + " </h1>");
        %>
        </h3>
    </div>
    <div class="col-4"></div>
  </div>
</div>

<%@include file="default/footer.jsp" %>
