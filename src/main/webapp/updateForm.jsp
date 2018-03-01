<%@ page import="com.mixail.model.Friends" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UpdateForm</title>
    <link href="css/stylesheet.css" type="text/css" rel="stylesheet">
</head>
<body>

<%Friends friends = (Friends) request.getAttribute("friend");%>
<h1>Update A Friend Record</h1>

<form name="updateForm" action="/updateFriend" method="get">

<table class="add">
    <tr>
        <td class="right">Friend id: </td>
        <td> <input type="text" name="id" readonly value="<%=friends.getFriendId()%>" > </td>

    </tr>

    <tr>
        <td class="right">Friend name </td>
        <td> <input type="text" name="name" value="<%=friends.getFriendName()%>"></td>

    </tr>

    <tr>
        <td class="right">Email Address: </td>
        <td>  <input type="text" name="email" value="<%=friends.getEmailAddr()%>"></td>

    </tr>


    <tr>
        <td class="right">Age: </td>
        <td>   <input type="text" name="age" value="<%=friends.getAge()%>"></td>

    </tr>

    <tr>
        <td class="right">Favotite color:</td>
        <td>   <input type="text" name="color" value="<%=friends.getFavoriteColor()%>"></td>

    </tr>
</table>
    <input type="submit" name="submit" value="Update">
    <input type="reset" name="reset" value="clear">
</form>
</body>
</html>
