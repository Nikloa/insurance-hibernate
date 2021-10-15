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
    <style>
        <%@include file="../css/offer.css"%>
    </style>
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

</html>
</html>
