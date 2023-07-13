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
    <label>Date of start:</label><input type="text" name="dateOfStart">
    <label>Date of finish:</label><input type="text" name="dateOfFinish">
    <input type="submit" value="save-group">
</form>
</body>
</html>
