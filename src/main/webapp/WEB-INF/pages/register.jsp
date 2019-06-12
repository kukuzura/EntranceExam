<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset=utf-8">
    <title><spring:message key="registration.title"/></title>
</head>

<body>
<form:form id="regForm" modelAttribute="user" action="registerProcess" method="post" >
    <table align="center">
        <tr>
            <td>
                <form:label path="login"><spring:message key="registration.lable.login"/></form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login" />
            </td>
            <td>
                <form:errors path="login" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password"><spring:message key="registration.lable.password"/></form:label>
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
                <form:button id="register" name="register"><spring:message key="registration.button.confirm"/></form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="/"><spring:message key="registration.button.home"/></a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
