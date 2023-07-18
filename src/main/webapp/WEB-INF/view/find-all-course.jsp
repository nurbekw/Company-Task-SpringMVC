<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 08.07.2023
  Time: 23:27
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
        <th>Course name</th>
        <th>Duration</th>
        <th>Teacher</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAllCourse}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>
                <a href="/course/controller/get/by/${course.id}">${course.courseName}</a>
            </td>
            <td>${course.duration}</td>

            <td>
                <button>
                    <a href="/teacher/controller/teacherrr">TEACHER</a>
                </button>
            </td>

            <td>
                <form action="/course/controller/delete/${course.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/course/controller/update/${course.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/course/controller/courseForm">save-course</a>
<br>
<a href="/course/controller/clear-course">truncate</a>
<br>
<button><a href="/course/controller/backToCompany">BACK</a></button>
<br>
<button><a href="/course/controller/menu">MENU</a></button>
</body>
</html>
