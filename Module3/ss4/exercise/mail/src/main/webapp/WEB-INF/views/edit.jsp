<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/16/2023
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mail" action="/mail/home" method="post">
    <fieldset>
        <legend>Settings</legend>
        <table>
            <tr>
                <th>Languages</th>
                <td><form:select path="languages">
                    <form:option value="VietNamese">VietNamese</form:option>
                    <form:option value="France">France</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                </form:select></td>
            </tr>
            <tr>
                <th>Page Size:</th>
                <td><form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="20">20</form:option>
                    <form:option value="26">25</form:option>
                </form:select></td>
            </tr>
            <tr>
                <th>Spams Filter:</th>
                <td><form:checkbox path="filter" value="1" >Enable spams filter</form:checkbox></td>
            </tr>
        </table>
    </fieldset>

</form:form>
</body>
</html>
