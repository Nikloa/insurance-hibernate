<%@ page import="ru.vironit.app.entities.Client" %>
<%@ page import="ru.vironit.app.dao.filter.ServletUtils" %>
<!DOCTYPE html>
<html lang="en">
<!--
<head>
    <meta charset="UTF-8">
    <title>First Web Project</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h1>First Web App</h1>
    </div>

    <div class="w3-container w3-center">
        <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/list'">List users</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/add'">Add user</button>
        </div>
    </div>
</body>
-->
<head>
    <meta charset="UTF-8">
    <title>Insurance</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>

<ul>
    <a><span class="icon-phone2"></span><span class="text">+ 1235 2355 98</span></a>
    <a><span class="icon-paper-plane"></span> <span class="text">youremail@email.com</span></a>

    <%
        if(ServletUtils.getLoggedUser(request.getSession()) != null) {
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
    <li><a class="active" href='/'>Home</a></li>
    <li style="float: revert">
        <form>
        <input type="text" name="search" placeholder="Search..">
        <input type="submit" value="Search">
        </form>
    </li>
</ul>
<div class="bg">
    <div class="grid-container">
        <form action="" method="post" class="">
            <input type="text" name="search" placeholder="Search..">
            <select name="" id="" class="" placeholder="Keyword search">
                <option value="">Where</option>
                <option value="">San Francisco USA</option>
                <option value="">Berlin Germany</option>
                <option value="">London United Kingdom</option>
                <option value="">Paris Italy</option>
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
<style>
    body, html {
        height: 100%;
        margin: 0;
    }

    .bg {
        background-image: url(https://cdn.pixabay.com/photo/2021/09/25/10/08/road-6654573_960_720.jpg);

        height: 100%;

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
        position: absolute;
        top: 50%;
        left: 50%;
        margin-right: -50%;
        transform: translate(-50%, -50%);
        display: grid;
        grid-template-columns: auto auto auto;
        grid-gap: 10px;
        background-color: #2196F3;
        padding: 10px;
    }

    .grid-container > div {
        background-color: rgba(255, 255, 255, 0.8);
        border: 1px solid black;
        text-align: center;
        font-size: 15px;
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