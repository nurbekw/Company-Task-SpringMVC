<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>First name</th>
        <th>Last name</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAllTeacher}" var="teacher">
        <tr>
            <td>${teacher.id}</td>

            <td>
                ${teacher.email}
            </td>

            <td>
                <a href="/teacher/controller/get/by/${teacher.id}">${teacher.first_name}</a>
            </td>

            <td>${teacher.last_name}</td>

            <td>
                <form action="/teacher/controller/delete/${teacher.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>

            <td>
                <form action="/teacher/controller/update/${teacher.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/teacher/controller/teacherForm">save-teacher</a>
<br>
<a href="/teacher/controller/clear-teacher">truncate</a>
<br>
<button><a href="/course/controller/courseee">BACK</a></button>
<br>
<button><a href="/teacher/controller/menu">MENU</a></button>
</body>
</html>
