<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/company/update/${company.id}" method="post">
<label>Company name:</label><input value="${company.companyName}" type="text" name="companyName">
<label>Located County:</label><input value="${locatedCounty}" type="text" name="locatedCounty">
<input type="submit" value="update-company">
</form>
</body>
</html>