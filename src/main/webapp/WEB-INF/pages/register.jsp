<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Registration</title>
</head>

<body>
<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="login">Username</form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login"/>
            </td>
            <td>
                <form:errors path="login" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password"/>
            </td>
            <td>
                <form:errors path="password" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="register" name="register">Register</form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
        <tr>
            <td><a href="<c:url value='..' />">Home</a>
            </td>
        </tr>
        </tr>
    </table>
</form:form>
</body>
</html>
