<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read jsp page</title>
    <link href="css/stylesheet.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="wrap">

    <!--Header-->
    <%@ include file="includes/header.jsp" %>


    <!--Menu-->
    <%@ include file="includes/newjspmenu.jsp" %>
    <!--Main-->
    <div class="main">


<% String table = (String) request.getAttribute("table");%>

<h1> My Friends</h1>

<%=table%>

<a href="/addFriend">Add A New Friend</a>
<br> <br>
<a href="search.jsp"> Search Friends</a>
<br>
<a href="/read" >View All Friend</a>
    </div>

    <!--Footer-->

    <%@ include file="includes/footer.jsp" %>
</div>


</body>
</html>
