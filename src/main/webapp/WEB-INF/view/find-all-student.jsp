<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 16:44
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
        <th>First name</th>
        <th>Last name</th>
        <th>email</th>
        <th>Study format</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAllStudent}" var="student">
        <tr>

            <td>${student.id}</td>

            <td>
                <a href="/student/controller/get/by/${student.id}">${student.first_name}</a>
            </td>

            <td>${student.last_name}</td>

            <td>${student.email}</td>

            <td>${student.studyFormat}</td>

            <td>
                <form action="/student/controller/delete/${student.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/student/controller/update/${student.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>

        </tr>

    </c:forEach>
    </tbody>
</table>
<a href="/student/controller/studentForm">save-student</a>
<br>
<a href="/student/controller/clear-student">truncate</a>
<br>
<button><a href="/group/controller/grouppp">BACK</a></button>
<br>
<button><a href="/student/controller/menu">MENU</a></button>
</body>
</html>
