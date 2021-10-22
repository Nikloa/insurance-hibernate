<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.10.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insurance</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="../css/login.css"/>
    <style>
        <%@include file="../css/login.css"%>
    </style>
</head>
<body>
<div class="bg">
    <form method="post" class="container" th:th:action="@{/login}" th:object="${client}">
        <span class="closebtn" onclick="history.back()" title="Back">×</span>
        <h1>Login</h1>

        <label>Email:
            <input type="email" name="email" placeholder="Enter Email" th:field="*{email}"><br />
        </label>
        <label>Password:
            <input type="password" name="password" placeholder="Enter Password" th:field="*{password}"><br />
        </label>
        <%
            if(!request.getHeader("referer").equals("http://localhost:8080/login")) {
                session.setAttribute("referer", request.getHeader("referer"));
            }
        %>
        <button type="submit" class="btn" name="button" value="${referer}">Submit</button>
    </form>
</div>

</body>
</html>
