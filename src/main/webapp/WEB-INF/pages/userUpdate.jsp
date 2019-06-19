<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <style>
        <%@include file="/resources/css/login.css" %>
    </style>

    <title><spring:message code="edit.title"/> </title>
</head>

<div class="container">
<body>
<jsp:include page="/WEB-INF/pages/navigation.jsp"/>
<form:form id="updateForm" modelAttribute="user" action="../updateProcess" method="post">
    <table>
        <tr>
            <td>
                <input type="hidden" id="id" name="id" value="${user.id}" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="login"><spring:message code="edit.lable.login"/></form:label>
            </td>
            <td>
                <form:input path="login" name="login" id="login" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password"><spring:message code="edit.lable.password"/></form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="update" name="update"><spring:message code="edit.button.confirm"/></form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
        </tr>
    </table>
</form:form></body>
</div>
</html>
