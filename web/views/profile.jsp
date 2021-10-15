<%@ page import="ru.vironit.app.dao.filter.ServletUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.vironit.app.entities.*" %>
<%@ page import="ru.vironit.app.services.*" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.10.2021
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        <%@include file="../css/profile.css"%>
    </style>
</head>
<body>
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
        <% Client client = (Client) ServletUtils.getLoggedUser(session);
        Passport passport = new PassportService().extractPassport(client.getId());
        ArrayList<Contract> contracts = new ContractService().listClientContract(client.getId());
        %>
        <h1 align="center"><%out.println(client.getNickname());%></h1>
        <div class="w3-row-padding">
            <div class="w3-third">
                <img src="https://icon-library.com/images/no-photo-available-icon/no-photo-available-icon-20.jpg" />
                <p>Email: <%out.println(client.getEmail());%></p>
                <p>Your rating: <%out.println(client.getRating());%></p>
                <p>Your balance: <%out.println(client.getBalance());%>$</p>
                <p><button>Search Insurance</button></p>
                <p><button>Change Profile</button></p>
                <p><button>Passport Data</button></p>
                <p>
                    <%
                    if(passport != null) {
                        if(passport.isConfirmation()) {
                            out.println("Passport data checked!");
                        } else {
                            out.println("Passport data don't checked");
                        }
                    } else {
                        out.println("Passport data don't entered");
                    }
                    %>
                </p>
            </div>
            <div class="w3-twothird">
                <h2>My Contracts</h2>
                <%
                if(!contracts.isEmpty()) {
                    for(Contract contract : contracts) {
                        Offer offer = new OfferService().extractOffer(contract.getOfferId());
                        Insurer insurer = new InsurerService().extractInsurer(offer.getInsurerId());
                        InsuranceType insuranceType = new InsuranceTypeService().extractInsuranceType(offer.getInsuranceTypeId());
                        out.println("<h4>" + insuranceType.getInsuranceType() + "</h4>" +
                        "");
                    }
                } else {
                    out.println("<h4>No have actual contracts</h4>");
                }
                %>
            </div>
        </div>
    </div>
</div>
</body>

</html>
