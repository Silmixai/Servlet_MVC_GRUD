<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Friends</title>
    <link rel="stylesheet" href="/css/stylesheet.css">
</head>
<body>
<div class="wrap">

    <!--Header-->
    <%@ include file="includes/header.jsp" %>


    <!--Menu-->
    <%@ include file="includes/newjspmenu.jsp" %>
    <!--Main-->
<div class="main">
    <h1> My Friends Database</h1>
    <a href="/read">View All Friend</a>
    <br> <br>
    <a href="search.jsp"> Search Friends</a>

</div>


    <!--Footer-->

    <%@ include file="includes/footer.jsp" %>
</div>
</body>

</html>
