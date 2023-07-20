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
    <style>
        <%@include file="/WEB-INF/view/css/styleForm.css"%>
    </style>
</head>
<body>
<form action="/course/controller/form-course" method="post">
    <label>Course name:</label><input type="text" name="courseName">
    <br>
    <label>Duration:</label><input type="date" name="duration">
    <br>
    <c:forEach items="${conCompany}" var="company">
    <input type="checkbox" id="${company.id}" name="id" value="${company.id}" class="asd"/>
    <label for="${company.id}">${company.companyName}</label>
    </c:forEach>
    <br>
    <input type="submit" value="save-course">
    <br>
    <button><a href="/course/controller/courseee">BACK</a></button>
    <br>
    <button><a href="/course/controller/menu">MENU</a></button>
</form>
</body>
</html>
