<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/teacher/controller/teacher/update/${teacher.id}" method="post">
  <label>Email:</label><input value="${teacher.email}" type="text" name="email">
  <label>First name:</label><input value="${teacher.first_name}" type="text" name="first_name">
  <label>Last name:</label><input value="${teacher.last_name}" type="text" name="last_name">
    <br>
  <input type="submit" value="update-teacher">
  <br>
  <button><a href="/course/controller/courseee">BACK</a></button>
    <br>
    <button><a href="/teacher/controller/menu">MENU</a></button>
</form>
</body>
</html>
