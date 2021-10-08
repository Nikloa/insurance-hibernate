<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.2021
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--
<head>
    <title>Add New User</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>First Web App</h1>
        </div>

        <div class="w3-container w3-padding">
            <%/*
                if (request.getAttribute("userName") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                            "   <h5>User '" + request.getAttribute("userName") + "' added!</h5>\n" +
                            "</div>");
                }
            */%>
        <div class="w3-card-4">
            <div class="w3-container w3-center w3-green">
                <h2>Add user</h2>
            </div>

            <form method="post" class="w3-selection w3-light-grey w3-padding">
                <label>Name:
                    <input type="text" name="nickname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <label>Password:
                    <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                </label>
                <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
            </form>
            </div>
        </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
        </div>
    </body>
-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insurance</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

<div class="bg">

    <form method="post" class="container">
        <h1>Sing Up</h1>

        <label>Nickname:
            <input type="text" name="nickname" placeholder="Enter Nickname"><br />
        </label>
        <label>Email:
            <input type="email" name="email" placeholder="Enter Email"><br />
        </label>
        <label>Password:
            <input type="password" name="password" placeholder="Enter Password"><br />
        </label>
        <label>
            <input type="tel" name="phone"><br />
        </label>
        <button type="submit" class="btn">Submit</button>
        <a href='/addInsurer'>I'm insurer</a>
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

    .checkmark {
        color: white;
        padding: 16px;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    .checkmark:hover {
        opacity: 1;
    }

</style>
<style>
    body, html {
        height: 100%;
        margin: 0;
    }

    .bg {
        background-image: url("../../../src/main/resources/images/register_bg.jpg");

        height: 100%;

        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
</html>
