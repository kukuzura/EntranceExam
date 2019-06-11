<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=utf-8">
    <title><spring:message key="login.title"/></title>
</head>

<body>
<form:form action="login" method="post" class="form-signin">
    <table align="center">
        <tr>
            <td>
                <form:label path="login"><spring:message key="login.lable.login"/></form:label>
            </td>
            <td>
                <form:input path="login" name="login" class="form-control"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password"><spring:message key="login.lable.password"/></form:label>
            </td>
            <td>
                <form:password path="password" name="password" class="form-control"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="login" name="login"><spring:message key="login.button.confirm"/></form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href=""><spring:message key="login.button.home"/></a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
