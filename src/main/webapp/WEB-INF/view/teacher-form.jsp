<%--
  Created by IntelliJ IDEA.
  User: nurbe
  Date: 12.07.2023
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/form-teacher" method="post">
  <label>Email:</label><input type="text" name="email">
  <label>First name:</label><input type="text" name="first_name">
  <label>Last name:</label><input type="text" name="last_name">
  <input type="submit" value="save-teacher">
</form>
</body>
</html>
