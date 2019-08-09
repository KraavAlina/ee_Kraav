<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Denerika</title>
</head>
<body>
<%
    response.getWriter().println(request.getAttribute("Hello"));
    response.getWriter().println(request.getParameter("login"));
%>
</body>
</html>
