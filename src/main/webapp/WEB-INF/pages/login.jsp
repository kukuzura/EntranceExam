<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
    <title><spring:message key="login.title"/></title>
</head>

<style>
    .error {
        color: red;
        font-size: 14px;
    }
    <%@include file="/WEB-INF/pages/css/link.css" %>
    <%@include file="/WEB-INF/pages/css/login.css" %>
</style>

<body>

<div class="container">
<form:form action="login_process" method="post" class="form-signin">
    <table align="center">
        <c:if test="${not empty error}">
            <div align="center" class="error">${error}</div>
        </c:if>
        <tr>
            <td>
                <label><spring:message key="login.lable.login"/></label>
            </td>
            <td>
                <input type="text" name="login"/>
            </td>
        </tr>
        <tr>
            <td>
                <label ><spring:message key="login.lable.password"/></label>
            </td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button><spring:message key="login.button.confirm"/></button>
            </td>
        </tr>
        <tr>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </tr>
        <tr>
            <td></td>
            <td><a href="/"><spring:message key="login.button.home"/></a>
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
