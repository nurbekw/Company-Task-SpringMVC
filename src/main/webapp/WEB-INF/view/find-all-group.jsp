<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 09.07.2023
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" >
    <thead>
    <tr>
        <th>id</th>
        <th>Group name</th>
        <th>Date of start</th>
        <th>Date of finish</th>
        <th>Student</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAllGroup}" var="group">
        <tr>
            <td>${group.id}</td>

            <td>
                <a href="/group/controller/get/by/${group.id}">${group.groupName}</a>
            </td>

            <td>${group.dateOfStart}</td>

            <td>${group.dateOfFinish}</td>

            <td>
                <button>
                <a href="/student/controller/studenttt">STUDENT</a>
                </button>
            </td>

            <td>
                <form action="/group/controller/delete/${group.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>

            <td>
                <form action="/group/controller/update/${group.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/group/controller/groupForm">save-group</a>
<br>
<a href="/group/controller/clear-group">truncate</a>
<br>
<button><a href="/group/controller/backToCompany">BACK</a></button>
<br>
<button><a href="/group/controller/menu">MENU</a></button>
</body>
</html>
