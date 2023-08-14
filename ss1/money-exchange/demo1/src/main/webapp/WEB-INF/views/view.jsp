<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/14/2023
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <fieldset>
        <legend>Money Exchange</legend>
        <table>
            <tr>
                <td>USD</td>
                <td>VND</td>
            </tr>
            <tr>
                <td><input type="number" name="number1" placeholder="usd"></td>
                <td><input type="text" name="number2" value="${number2}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
