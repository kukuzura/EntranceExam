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
    <title><spring:message code="edit.title"/></title>
</head>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/updateUser.js"></script>
<body>
<div class="container">
    <form:form id="editForm" modelAttribute="user" >
        <table>
            <tr>
                <td>
                    <input type="hidden" id="id" name="id" value="${user.id}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="login"><spring:message code="edit.lable.login"/></label>
                </td>
                <td>
                    <form:input path="login" type="text" id="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="password"><spring:message code="edit.lable.password"/></label>
                </td>
                <td>
                    <input name="password" type="password" id="password"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" id="submit" value="<spring:message code="edit.button.confirm"/>"/>
                </td>
            </tr>
            <tr>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
