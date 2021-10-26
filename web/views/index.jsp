<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="ru.vironit.app.entities.Role" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Insurance</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="../css/index.css" rel="stylesheet" type="text/css" media="screen"/>
    <style>
        <%@include file="../css/index.css"%>
    </style>
</head>
<body>
<div class="bg">
<ul>
    <a><span class="icon-phone2"></span><span class="text">+ 1235 2355 98</span></a>
    <a><span class="icon-paper-plane"></span> <span class="text">youremail@email.com</span></a>

    <c:if test="${user != null}">
        <li>
            <div class="dropdown" style="float: right">
                <button class="dropbtn">Profile</button>
                <div class="dropdown-content">
                    <c:if test="${user.getRole() == Role.CLIENT}">
                        <a href='<c:url value="/profile"/>'>${user.getEmail()}</a>
                    </c:if>
                    <c:if test="${user.getRole() == Role.INSURER}">
                        <a href='<c:url value="/profileInsurer"/>'>${user.getEmail()}</a>
                    </c:if>
                    <form method="post"><input style="float: right" type="submit" name="logout" value="Logout"></form>
                </div>
            </div>
        </li>
    </c:if>

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
    <li><a href='/offers'>Offers</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#news">News</a></li>
    <li><a class="active" href='/'>Home</a></li>
    <li style="float: revert">
        <form>
        <input type="text" name="search" placeholder="Search..">
        <input type="submit" value="Search">
        </form>
    </li>
</ul>

    <div class="grid-container">
        <form action="" method="post" class="">
            <select name="" id="insuranceTypeList" class="">
                <c:forEach var="type" items="${typeList}">
                    <option value="${type.getId()}">${type.getInsuranceType()}</option>
                </c:forEach>
            </select>
            <input type="submit" class="" value="Search">
        </form>
    </div>
    <div id="myOverlay" class="overlay">
        <span class="closebtn" onclick="closeChoice()" title="Close Overlay">x</span>
        <div class="overlay-content">
                <button class="btn" onclick="location.href='/loginInsurer'">Insurer</button>
                <button class="btn" onclick="location.href='/login'">Client</button>
        </div>
    </div>
</div>


<script>
    function openChoice() {
        document.getElementById("myOverlay").style.display = "block";
    }

    function closeChoice() {
        document.getElementById("myOverlay").style.display = "none";
    }
</script>

</body>
</html>