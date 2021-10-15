<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.10.2021
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insurance</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}https://www.w3schools.com/w3css/4/w3.css">
    <style>
        <%@include file="../css/login.css"%>
    </style>
</head>
<body>

<div class="bg">
    <form method="post" class="container">
        <span class="closebtn" onclick="location.href='/'" title="Close Overlay">×</span>
        <h1>Login</h1>

        <label>Email:
            <input type="email" name="email" placeholder="Enter Email"><br />
        </label>
        <label>Password:
            <input type="password" name="password" placeholder="Enter Password"><br />
        </label>
        <%
            if(!request.getHeader("referer").equals("http://localhost:8080/loginInsurer")) {
                session.setAttribute("referer", request.getHeader("referer"));
            }
        %>
        <button type="submit" class="btn" name="button" value="${referer}">Submit</button>
    </form>
</div>

</body>

</html>
