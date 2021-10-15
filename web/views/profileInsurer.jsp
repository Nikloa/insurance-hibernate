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
        <%@include file="../css/profileInsurer.css"%>
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
                        "<form method=\"post\"><input style=\"float: right\" class=\"searchSubmit\" type=\"submit\" name=\"logout\" value=\"Logout\"></form>" +
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
                <input class="search" type="text" name="search" placeholder="Search..">
                <input class="searchSubmit" type="submit" value="Search">
            </form>
        </li>
    </ul>
    <div class="grid-container">
        <% Insurer insurer = (Insurer) ServletUtils.getLoggedUser(session);
        Licence licence = new LicenceService().extractLicence(insurer.getId());
        ArrayList<Offer> offers = new OfferService().listInsurerOffer(insurer.getId());
        %>
        <h1 align="center"><%out.println(insurer.getCompanyName());%></h1>
        <div class="w3-row-padding">
            <div class="w3-third">
                <img src="https://icon-library.com/images/no-photo-available-icon/no-photo-available-icon-20.jpg" />
                <p>Email: <%out.println(insurer.getEmail());%></p>
                <p>Your rating: <%out.println(insurer.getRating());%></p>
                <p><button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large">Create Offer</button></p>
                <p><form><button type="submit" name="changeProfile" value="ty">Change Profile</button></form></p>
                <p><button>Licence Data</button></p>
                <p>
                    <%
                    if(licence != null) {
                        if(licence.isConfirmation()) {
                            out.println("Licence data checked!");
                        } else {
                            out.println("Licence data don't checked");
                        }
                    } else {
                        out.println("Licence data don't entered");
                    }
                    %>
                </p>
            </div>
            <div class="w3-twothird">
                <h2>My Contracts</h2>
                <table>
                <%
                if(!offers.isEmpty()) {
                    for(Offer offer : offers) {
                        InsuranceType insuranceType = new InsuranceTypeService().extractInsuranceType(offer.getInsuranceTypeId());
                        out.println("<tr>\n" +
                                "       <td colspan=\"5\" class=\"tdfirst\">\n" +
                                "           <details>\n" +
                                "               <summary>" + insuranceType.getInsuranceType() + "</summary>\n" +
                                "               <p>" + offer.getDescription() + "</p>\n" +
                                "           </details>\n" +
                                "       </td>\n" +
                                "    </tr>\n" +
                                "    <tr>\n" +
                                "       <td class=\"td\">" + offer.getCost() + "$</td>" +
                                "       <td class=\"td\">" + offer.getTerm() + " days</td>" +
                                "       <td class=\"td\">Counter</td>" +
                                "       <td class=\"td\"><button type=\"submit\" name=\"visibleButton\" value=\"true\">Visible</button></td>" +
                                "       <td class=\"td\">delete</td>\n" +
                                "    </tr>"
                        );
                    }
                } else {
                    out.println("<h4>No have actual contracts</h4>");
                }
                %>
                </table>
            </div>
        </div>

    </div>
    <div id="id01" class="w3-modal">
        <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

            <div class="w3-center"><br>
                <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
            </div>

            <form class="w3-container" method="post" name="form">
                <div class="w3-section">
                    <label><b>Insurance Type</b></label>
                    <select name="insuranceType" id="" class="w3-input w3-border w3-margin-bottom" placeholder="Keyword search">
                        <%
                            ArrayList<InsuranceType> typeList= new InsuranceTypeService().allInsuranceType();
                            for(InsuranceType type : typeList) {
                                out.println("<option value=\"" + type.getId() + "\">" + type.getInsuranceType() + "</option>");
                            }
                        %>
                    </select>
                    <label><b>Description</b></label>
                    <textarea cols="60" rows="5" class="w3-input w3-border" placeholder="Enter Description" name="description" required></textarea>
                    <label><b>Term</b></label>
                    <div class="w3-input w3-border w3-margin-bottom">
                        <input  class="w3-input" type="number" placeholder="Enter Term" name="term" id="term" required>
                        <select class="w3-input" name="termType">
                            <option value="1">Days</option>
                            <option value="7">Weeks</option>
                            <option value="30">Months</option>
                            <option value="365">Years</option>
                        </select>
                    </div>
                    <label><b>Cost</b></label>
                    <div class="w3-input w3-border w3-margin-bottom">
                        <label><b>$</b><input type="number" placeholder="Enter Cost" name="cost" required></label>
                    </div>
                    <div class="puc">
                        <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit" name="offerButton" value="true">Add</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
