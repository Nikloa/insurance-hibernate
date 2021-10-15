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
    <style>
        <%@include file="../css/add.css"%>
    </style>
</head>
<body>

<div class="bg">
    <%
        if (request.getAttribute("error") != null) {
            out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Email '" + request.getAttribute("error") + "' already exist!</h5>\n" +
                    "</div>");
        }
    %>
    <form method="post" class="container">
        <span class="closebtn" onclick="history.back()" title="Back">×</span>
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
        <label>Phone:
            <input type="text" class="mask" name="phone" placeholder="+375 (12) 345-67-89">
        </label>
        <button type="submit" class="btn">Submit</button>
        <a href='/addInsurer'>I'm insurer</a>
    </form>
</div>
<script src="https://unpkg.com/imask"></script>
<script>
    var elements = document.getElementsByClassName('mask');
    for (var i = 0; i < elements.length; i++) {
        new IMask(elements[i], {
            mask: '+{375} (00) 000-00-00',
        });
    }
</script>
</body>
</html>
