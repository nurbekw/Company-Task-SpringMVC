<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 11.07.2023
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/group/controller/group/update/${group.id}" method="post">
  <label>Group name:</label><input value="${group.groupName}" type="text" name="groupName">
  <label>Date of start:</label><input value="${group.dateOfStart}" type="text" name="dateOfStart">
    <label>Date of finish:</label><input value="${group.dateOfFinish}" type="text" name="dateOfFinish">
    <input type="submit" value="update-group">
</form>
</body>
</html>