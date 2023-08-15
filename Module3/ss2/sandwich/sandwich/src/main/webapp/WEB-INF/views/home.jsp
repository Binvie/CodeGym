<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/15/2023
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sandwich/save" method="post">
    <h1>Sandwich Condiments</h1>
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" value="lettuce" id="lettuce" name="condiments">
    <label for="tomato">Tomato</label>
    <input type="checkbox" value="tomato" id="tomato" name="condiments">
    <label for="mustard">Mustard</label>
    <input type="checkbox" value="mustard" id="mustard" name="condiments">
    <label for="Sprouts">Sprouts</label>
    <input type="checkbox" value="Sprouts" id="Sprouts" name="condiments">
    <input type="submit" value="Save">
    <div>${list}</div>
    <div>${message}</div>
</form>
</body>
</html>
