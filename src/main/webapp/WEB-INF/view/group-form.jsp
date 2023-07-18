<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 11.07.2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/group/controller/form-group" method="post">
    <label>Group name:</label><input type="text" name="groupName">
    <label>Date of start:</label><input type="date" name="dateOfStart">
    <label>Date of finish:</label><input type="date" name="dateOfFinish">
    <br>
    <c:forEach items="${conCompanies}" var="company">
        <input type="checkbox" id="${company.id}" name="id" value="${company.id}" />
        <label for="${company.id}">${company.companyName}</label>
    </c:forEach>
    <br>
    <c:forEach items="${conCourse}" var="idCourse">
        <input type="checkbox" id="${idCourse.id}" name="idCourse" value="${idCourse.id}" />
        <label for="${idCourse.id}">${idCourse.courseName}</label>
    </c:forEach>
    <br>
    <input type="submit" value="save-group">
    <br>
    <button><a href="/group/controller/grouppp">BACK</a></button>
    <br>
    <button><a href="/group/controller/menu">MENU</a></button>
</form>
</body>
</html>
