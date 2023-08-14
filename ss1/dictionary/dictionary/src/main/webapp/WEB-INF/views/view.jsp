<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/14/2023
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/view" method="post">
    <fieldset>
        <legend>Dictionary</legend>
        <table>
            <tr>
                <td>English</td>
                <td>VietNamese</td>
            </tr>
            <tr>
                <td><input type="text" name="word"></td>
                <td>${result}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
