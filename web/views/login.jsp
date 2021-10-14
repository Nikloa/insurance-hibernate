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
</head>
<body>
<div class="bg">
    <form method="post" class="container">
        <span class="closebtn" onclick="history.back()" title="Back">×</span>
        <h1>Login</h1>

        <label>Email:
            <input type="email" name="email" placeholder="Enter Email"><br />
        </label>
        <label>Password:
            <input type="password" name="password" placeholder="Enter Password"><br />
        </label>

        <button type="submit" class="btn" name="button" value="<%out.println(request.getHeader("referer"));%>">Submit</button>
    </form>
</div>

</body>
<style>
    body, html {
        height: 100%;
        font-family: Arial, Helvetica, sans-serif;
    }

    * {
        box-sizing: border-box;
    }

    /* Add styles to the form container */
    .container {
        position: absolute;
        top: 50%;
        left: 50%;
        margin-right: -50%;
        transform: translate(-50%, -50%);
        max-width: 500px;
        padding: 16px;
        background-color: white;
    }

    /* Full-width input fields */
    input[type=text], input[type=password], input[type=email] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        border: none;
        background: #f1f1f1;
    }

    input[type=text]:focus, input[type=password], input[type=email]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Set a style for the submit button */
    .btn {
        background-color: #04AA6D;
        color: white;
        padding: 16px 20px;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    .btn:hover {
        opacity: 1;
    }

    .closebtn {
        position: absolute;
        top: 0;
        right: 5%;
        font-size: 60px;
        cursor: pointer;
        color: #a1a1a1;
    }

    .closebtn:hover {
        color: #7a7a7a;
    }
</style>
<style>
    body, html {
        height: 100%;
        margin: 0;
    }

    .bg {
        background-image: url(https://cdn.pixabay.com/photo/2014/01/04/12/34/road-238458_960_720.jpg);

        height: 100%;

        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
</html>
