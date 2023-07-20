<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="it.controller.studyformat.StudyFormat" %><%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 18:17
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
<form action="/student/controller/student/update/${student.id}" method="post">
  <label>First name:</label><input value="${student.first_name}" type="text" name="first_name">
  <br>
  <label>Last name:</label><input value="${student.last_name}" type="text" name="last_name">
  <br>
  <label>email:</label><input value="${student.email}" type="email" name="email">
  <br>
  <select name="studyFormat" size="1">
    <option>ONLINE</option>
    <option>OFFLINE</option>
  </select>
  <br>
  <input type="submit" value="update-student">
  <br>
  <button><a href="/student/controller/studenttt"> BACK </a></button>
  <br>
  <button><a href="/student/controller/menu">MENU</a></button>
</form>
</body>
</html>
