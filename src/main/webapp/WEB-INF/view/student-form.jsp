<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="it.controller.studyformat.StudyFormat" %><%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 16:54
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
<form action="/student/controller/form-student" method="post">
  <label>First name:</label><input type="text" name="first_name">
    <br>
  <label>Last name:</label><input type="text" name="last_name">
    <br>
  <label>email:</label><input type="email" name="email">
    <br>
    <select name="studyFormat" size="1">
        <option>ONLINE</option>
        <option>OFFLINE</option>
    </select>
    <br>
    <c:forEach items="${conGroup}" var="group">
        <input type="checkbox" id="${group.id}" name="id" value="${group.id}" class="asd"/>
        <label for="${group.id}">${group.groupName}</label>
    </c:forEach>
    <br>
    <input type="submit" value="save-student">
    <br>
    <button><a href="/student/controller/studenttt"> BACK </a></button>
    <br>
    <button><a href="/student/controller/menu">MENU</a></button>
</form>
</body>
</html>
