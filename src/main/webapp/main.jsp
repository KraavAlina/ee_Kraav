<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.String" %>

<%@include file="default/header.jsp" %>


<%
    out.println("<h1>Login: " + (String) request.getAttribute("login") + " </h1>");
%>

<%@include file="default/footer.jsp" %>
