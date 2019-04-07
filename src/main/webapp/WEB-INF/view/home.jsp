<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.kangwen.util.Mappings" %>
<html>
<head>
    <title>Todo List Application</title>
</head>
<body>

    <div align="center">
        <c:url var="itemLinks" value="${Mappings.ITEMS}" />
        <h2><a href="${itemLinks}">TodoItems</a></h2>
    </div>


</body>
</html>
