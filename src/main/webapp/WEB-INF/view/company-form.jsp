<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/view/css/styleForm.css"%>
    </style>
</head>
<body>
<form action="/form-company" method="post">
  <label>Company name:</label><input type="text" name="companyName">
    <br>
  <label>Located County:</label><input type="text" name="locatedCounty">
    <br>
  <input type="submit" value="save-company">
    <br>
    <button><a href="/">BACK</a></button>
</form>
</body>
</html>