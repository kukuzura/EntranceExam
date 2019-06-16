<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
    <title><spring:message code="studentRegistration.title"/></title>
</head>

<style>
    .error {
        color: red;
        font-size: 14px;
    }
</style>

<body>

<form action="studentRegisterProcess" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table align="center">
        <tr>
            <spring:bind path="user.login">
                <td>
                    <label><spring:message code="studentRegistration.lable.login"/></label>
                </td>
                <td>
                    <input type="text" name="login"><br/>
                </td>
                <td>
                    <form:errors path="user.login" cssClass="error"/>
                </td>
            </spring:bind>
        </tr>
        <tr>
            <spring:bind path="user.password">
                <td>
                    <label><spring:message code="studentRegistration.lable.password"/></label>
                </td>
                <td>
                    <input type="password" name="password"><br/>
                </td>
                <td>
                    <form:errors path="user.password" cssClass="error"/>
                </td>
            </spring:bind>
        </tr>
        <spring:bind path="student.firstName">
            <td>
                <label><spring:message code="studentRegistration.lable.firstName"/></label>
            </td>
            <td>
                <input type="text" name="firstName"><br/>
            </td>
            <td>
                <form:errors path="student.firstName" cssClass="error"/>
            </td>
        </spring:bind>
        <tr>
            <spring:bind path="student.lastName">
                <td>
                    <label><spring:message code="studentRegistration.lable.lastName"/></label>
                </td>
                <td>
                    <input type="text" name="lastName"><br/>
                </td>
                <td>
                    <form:errors path="student.lastName" cssClass="error"/>
                </td>
    </spring:bind>
        </tr>
        <tr>
            <spring:bind path="student.patronymic">
                <td>
                    <label><spring:message code="studentRegistration.lable.patronymic"/></label>
                </td>
                <td>
                    <input type="text" name="patronymic"><br/>
                </td>
                <td>
                    <form:errors path="student.patronymic" cssClass="error"/>
                </td>
            </spring:bind>
        </tr>
        <tr>
        <spring:bind path="student.passportID">
            <td>
                <label><spring:message code="studentRegistration.lable.passportID"/></label>
            </td>
            <td>
                <input type="text" name="passportID"><br/>
            </td>
            <td>
                <form:errors path="student.passportID" cssClass="error"/>
            </td>
        </spring:bind>
        </tr>
        <tr align="center">
            <button><spring:message code="studentRegistration.button.confirm"/></button>
        </tr>


    </table>

</form>
</body>
</html>
