<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 09.07.2023
  Time: 0:05
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
<form action="/course/controller/course/update/${course.id}" method="post">
    <label>Course name:</label><input value="${course.courseName}" type="text" name="courseName">
    <br>
    <label>Duration:</label><input value="${course.duration}" type="date" name="duration">
    <br>
    <input type="submit" value="update-course">
    <br>
    <button><a href="/course/controller/courseee">BACK</a></button>
    <br>
    <button><a href="/course/controller/menu">MENU</a></button>
</form>
</body>
</html>
