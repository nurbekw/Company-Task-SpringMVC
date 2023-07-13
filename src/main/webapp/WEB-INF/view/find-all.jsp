<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Company</title>
</head>
<body>
<table border="1px" >
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
                <a href="/course/controller/courseee">COURSE</a>
            </td>

            <td>
                <a href="/group/controller/grouppp">GROUP</a>
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
<a href="/companyForm">save-company</a>
    <br>
<a href="/clear-company">truncate</a>
</body>
</html>