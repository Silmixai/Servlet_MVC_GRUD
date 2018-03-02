<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Search Jsp</title>
    <link href="../css/stylesheet.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="wrap">

    <!--Header-->
    <%@ include file="/includes/header.jsp" %>


    <!--Menu-->
    <%@ include file="/includes/newjspmenu.jsp" %>
    <!--Main-->
    <div class="main">

        <form name="searchForm" action="search" method="get">

            <input type="text" name="searchVal" value="">
            <br>
            <input type="submit" name="submit" value="search">

        </form>

    </div>

    <!--Footer-->

    <%@ include file="/includes/footer.jsp" %>
</div>


</body>
</html>
