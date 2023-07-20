<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Company</title>
    <style>
        <%@include file="/WEB-INF/view/css/style.css"%>
    </style>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>Company name</th>
        <th>Located county</th>
        <th>Course</th>
        <th>Group</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAllCompany}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>
                <a href="/get/by/${company.id}">${company.companyName}</a>
            </td>
            <td>${company.locatedCounty}</td>

            <td>
                <button>
                <a href="/course/controller/courseee">COURSE</a>
                </button>
            </td>

            <td>
                <button>
                <a href="/group/controller/grouppp">GROUP</a>
                </button>
            </td>

            <td>
                <form action="/delete/${company.id }" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/update/${company.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>

    </c:forEach>
    
    </tbody>
</table>
<button class="button">
<a href="/companyForm">save-company</a>
</button>
    <br>
<br>
<button class="button">
<a href="/clear-company">truncate</a>
</button>
</body>
</html>