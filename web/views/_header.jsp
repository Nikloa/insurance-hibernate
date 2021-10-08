<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.10.2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div style="background: #E0E0E0; height: 55px; padding: 5px;">
        <div style="float: left">
            <h1>My Site</h1>
        </div>

        <div style="float: right; padding: 10px; text-align: right;">

            <!-- User store in session with attribute: loginedUser -->
            Hello <b>${loginedUser.userName}</b>
            <br/>
            Search <input name="search">

        </div>

    </div>
</head>
<body>

</body>
</html>
