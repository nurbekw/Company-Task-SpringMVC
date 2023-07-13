<%@ page import="it.controller.studyformat.StudyFormatEnum" %><%--
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
</head>
<body>
<form action="/student/controller/update/${student.id}" method="post">
  <label>First name:</label><input value="${student.first_name}" type="text" name="first_name">
  <label>Last name:</label><input value="${student.last_name}" type="text" name="last_name">
  <label>email:</label><input value="${student.email}" type="email" name="email">
  <select name="studyFormat" size="1">
    <option value="first"><c:set var="ONLINE" value="<%=StudyFormatEnum.ONLINE%>"/></option>
    <option selected="selected" value="second"><c:set var="OFFLINE" value="<%=StudyFormatEnum.OFFLINE%>"/></option>
  </select>
  <input type="submit" value="update-student">
</form>
</body>
</html>
