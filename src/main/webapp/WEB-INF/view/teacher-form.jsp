<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 19:16
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
<form action="/teacher/controller/form-teacher" method="post">
    <label>Email:</label><input type="text" name="email">
    <br>
    <label>First name:</label><input type="text" name="first_name">
    <br>
    <label>Last name:</label><input type="text" name="last_name">
    <br>
    <c:forEach items="${conCourses}" var="course">
        <input type="checkbox" id="${course.id}" name="id" value="${course.id}" class="asd"/>
        <label for="${course.id}">${course.courseName}</label>
    </c:forEach>
    <br>
    <input type="submit" value="save-teacher">
    <br>
    <button><a href="/course/controller/courseee">BACK</a></button>
    <br>
    <button><a href="/teacher/controller/menu">MENU</a></button>
</form>
</body>
</html>
