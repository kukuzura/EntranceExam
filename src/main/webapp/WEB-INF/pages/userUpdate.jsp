<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body><form:form id="updateForm" modelAttribute="user" action="../updateProcess" method="post">
    <table>
        <tr>
            <td>
                <input type="hidden" id="id" name="id" value="${user.id}" />
            </td>
        </tr>
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
        <tr>
            <td><a href="<c:url value='..' />">Home</a>
            </td>
        </tr>
        <tr>
        </tr>
    </table>
</form:form></body>
</html>
