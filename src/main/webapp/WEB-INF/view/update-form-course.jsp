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
</head>
<body>
<form action="/course/controller/course/update/${course.id}" method="post">
    <label>Course name:</label><input value="${course.courseName}" type="text" name="courseName">
    <label>Duration:</label><input value="${course.duration}" type="text" name="duration">
    <input type="submit" value="update-course">
</form>
</body>
</html>
