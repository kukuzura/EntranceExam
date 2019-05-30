<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body><form:form id="updateForm" modelAttribute="user" action="../updateProcess/${user.id}" method="post">
    <table>
        <tr>
            <td>
                <form:label path="login">Username</form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="update" name="update">Update</form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
        </tr>
    </table>
</form:form></body>
</html>
