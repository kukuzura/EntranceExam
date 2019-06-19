<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
    <title><spring:message code="studentRegistration.title"/></title>
</head>

<style>
    .error {
        color: red;
        font-size: 14px;
        max-width: 100px;
    }
    <%@include file="/WEB-INF/pages/css/registration.css" %>
</style>

<body>
<jsp:include page="/WEB-INF/pages/navigation.jsp"/>
<div class="container">
<h1><spring:message code="studentRegistration.title"/></h1>
    <form action="/account/studentRegisterProcess" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table>
    <tr>
    <spring:bind path="user.login">
        <td>
            <label><spring:message code="studentRegistration.lable.login"/></label>
        </td>
        <td >
            <input type="text" name="login" />
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
            <input type="password" name="password"/>
        </td>
        <td>
            <form:errors path="user.password" cssClass="error"/>
        </td>
    </spring:bind>
    </tr>
    <spring:bind path="student.firstName">
        <td>
            <label><spring:message code="studentRegistration.lable.firstName" /></label>
        </td>
        <td>
            <input type="text" name="firstName" placeholder="<spring:message code="studentRegistration.placeholder.firstName"/>"/>
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
            <input type="text" name="lastName"  placeholder=<spring:message code="studentRegistration.placeholder.lastName"/>/>
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
            <input type="text" name="patronymic"  placeholder=<spring:message code="studentRegistration.placeholder.patronymic"/>/>
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
            <input type="text" name="passportID"  placeholder=<spring:message code="studentRegistration.placeholder.passportID"/>/>
         </td>
        <td>
            <form:errors path="student.passportID" cssClass="error"/>
        </td>
    </spring:bind>
    </tr>

    <tr>
    <td >
    <button ><spring:message code="studentRegistration.button.confirm"/></button>
    </td>
    </tr>
    </table>


    </form>
    </div>
    </body>
    </html>