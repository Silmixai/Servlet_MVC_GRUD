<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 27.02.2018
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add JSP Page</title>
</head>
<body>



<h1>Add A New Friend</h1>
<form name="addForm" action="add" method="get">

    <label>Friend name:</label>
    <input type="text" name="name" value="">
    <br>
    <label>Email Address:</label>
    <input type="text" name="email" value="">
    <br>
    <label>Age:</label>
    <input type="text" name="age" value="">
    <br>
    <label>Favotite color:</label>
    <input type="text" name="color" value="">
    <br>
    <input type="submit" name="submit" value="Submit">

</form>

</body>
</html>
