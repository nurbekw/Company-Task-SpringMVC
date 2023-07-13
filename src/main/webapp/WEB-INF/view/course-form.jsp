<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 08.07.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/course/controller/form-course" method="post">
    <label>Course name:</label><input type="text" name="courseName">
    <label>Duration:</label><input type="text" name="duration">
    <c:forEach items="${connection}" var="company">
    <input type="checkbox" name="company" value="${company.id}" />
    <label for="${company.id}">${company.companyName}</label>
    </c:forEach>
    <input type="submit" value="save-course">
</form>
</body>
</html>
