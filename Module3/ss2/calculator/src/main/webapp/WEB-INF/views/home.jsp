<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/15/2023
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculate/save" method="post">
    <h1>Calculator</h1>
    <p>Number 1</p>
    <input required type="number" name="number1" style="width: 30%">
    <p>Number 2</p>
    <input required type="number" name="number2" style="width: 30%">
    <hr>
    <button value="+" name="operator">Addition(+)</button>
    <button value="-" name="operator">Subtraction(-)</button>
    <button value="/" name="operator">Division(/)</button>
    <button value="x" name="operator">Multiplication(x)</button>
    <div>${result}</div>
    <div>${message}</div>
</form>
</body>
</html>
