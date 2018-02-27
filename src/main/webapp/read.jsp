<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read jsp page</title>
</head>
<body>

<% String table = (String) request.getAttribute("table");%>

<h1> My Friends</h1>

<%=table%>

</body>
</html>
