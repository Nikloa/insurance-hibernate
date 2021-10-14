<%@ page import="ru.vironit.app.dao.filter.ServletUtils" %>
<%@ page import="ru.vironit.app.entities.Offer" %>
<%@ page import="ru.vironit.app.services.OfferService" %>
<%@ page import="ru.vironit.app.entities.InsuranceType" %>
<%@ page import="ru.vironit.app.services.InsuranceTypeService" %>
<%@ page import="ru.vironit.app.entities.Insurer" %>
<%@ page import="ru.vironit.app.services.InsurerService" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.10.2021
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%System.out.println("offer jsp " + request.getHeader("referer"));%>
<div class="bg">
    <ul>
        <a><span class="icon-phone2"></span><span class="text">+ 1235 2355 98</span></a>
        <a><span class="icon-paper-plane"></span> <span class="text">youremail@email.com</span></a>

        <%
            if(ServletUtils.getLoggedUser(session) != null) {
                out.println("<li>" +
                        "<div class=\"dropdown\" style=\"float: right\">" +
                        "<button class=\"dropbtn\">Profile</button>" +
                        "<div class=\"dropdown-content\">" +
                        "<a href='/profile'>" + ServletUtils.getUserEmailInCookie(request) + "</a>" +
                        "<form method=\"post\"><input style=\"float: right\" type=\"submit\" name=\"logout\" value=\"Logout\"></form>" +
                        "</div>" +
                        "</div>" +
                        "</li>");
            }
        %>

        <li>
            <div class="dropdown" style="float: right">
                <button class="dropbtn">Sign Up</button>
                <div class="dropdown-content">
                    <a href='/add'>Client</a>
                    <a href='/addInsurer'>Insurer</a>
                </div>
            </div>
        </li>
        <li><a onclick="openChoice()">Sign In</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href="#news">News</a></li>
        <li><a href='/'>Home</a></li>
        <li style="float: revert">
            <form>
                <input type="text" name="search" placeholder="Search..">
                <input type="submit" value="Search">
            </form>
        </li>
    </ul>
    <div class="grid-container">
        <h2>Offers</h2>

            <%

                Offer offer = new OfferService().extractOffer((int) session.getAttribute("view"));

                Insurer insurer = new InsurerService().extractInsurer(offer.getInsurerId());
                InsuranceType insuranceType = new InsuranceTypeService().extractInsuranceType(offer.getInsuranceTypeId());
                out.println("<div>" +
                        "<h3>" + insuranceType.getInsuranceType() + "</h3>" +
                        "<h4>" + offer.getDescription() + "</h4>" +
                        "<h4>Cost: " + offer.getCost() + "$</h4>" +
                        "<h4>Term: " + offer.getTerm() + " days</h4>" +
                        "<h4>Company: " + insurer.getCompanyName() + "</h4>" +
                        "<h4>Rating: " + insurer.getRating() + "</h4>" +
                        "</div>");
            %>
        <form method="post">
            <button type="submit" name="buy" value="<%out.println(offer.getId());%>">Buy</button>
        </form>
    </div>
</div>
</body>
<style>
    .td{
        width: 900px;
        height:50px;
        border: solid 1px silver;
        text-align:center;
    }
    .tdfirst{
        width: 900px;
        height:50px;
        border: solid 1px silver;
        text-align:left;
    }
</style>
<style>
    body, html {
        height: 100%;
        margin: 0;
    }

    .bg {
        background-image: url(https://cdn.pixabay.com/photo/2021/09/25/10/08/road-6654573_960_720.jpg);

        min-height: 100vh;

        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }

</style>
<style>
    .dropbtn {
        background-color: #333;
        color: white;
        padding: 13px;
        font-size: 16px;
        border: none;
        cursor: pointer;
    }

    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        right: 0;
        background-color: #f9f9f9;
        min-width: auto;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;

    }

    .dropdown-content a:hover {background-color: #f1f1f1}

    .dropdown:hover .dropdown-content {
        display: block;
    }

    .dropdown:hover .dropbtn {
        background-color: #3e8e41;
    }
</style>
<style>
    .grid-container {
        position: relative;
        top: 0px;
        left: 50%;
        margin-right: -50%;
        transform: translate(-50%);
        background-color: #2196F3;
        padding: 10px;
        width: 1500px;
    }


</style>
<style>
    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: fragments;
        background-color: #333;
    }
    li {
        float: right;
    }
    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover:not(.active) {
        background-color: #111;
    }

    .active {
        background-color: #04AA6D;
    }
    a {
        float: left;
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }
    form input[type=text] {
        width: 130px;
        box-sizing: border-box;
        border-radius: 4px;
        font-size: 14px;
        background-color: rgba(222, 222, 222, 0.8);
        background-image: url('https://img.icons8.com/ios-filled/50/000000/search--v1.png');
        background-position: 10px 10px;
        background-repeat: no-repeat;
        background-size: 30px;
        padding: 12px 20px 12px 40px;
        -webkit-transition: width 0.4s ease-in-out;
        transition: width 0.4s ease-in-out;
    }

    form input[type=text]:focus {
        width: 45%;
    }
    form input[type=submit] {
        text-align: center;
        padding: 12px 20px;
        color: white;
        background-color: #04AA6D;
    }

</style>

<style>

    .overlay {
        height: 100%;
        width: 100%;
        display: none;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: rgb(0,0,0);
        background-color: rgba(0,0,0, 0.9);
    }

    .overlay-content {
        position: relative;
        top: 50%;
        left: 50%;
        margin-right: -50%;
        transform: translate(-50%, -50%);
        text-align: center;
    }

    .overlay .closebtn {
        position: absolute;
        top: 20px;
        right: 45px;
        font-size: 60px;
        cursor: pointer;
        color: white;
    }

    .overlay .closebtn:hover {
        color: #ccc;
    }

    .overlay button {
        position: relative;
        top: 50%;
        transform: translateY(-50%);
        margin: 50px;
        background: #368d45;
        width: 10%;
        height: 60px;
        text-align: center;
    }

    .overlay button:hover {
        background: #6ab65c;
    }
</style>
</html>
</html>
