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
<script>
    var RestPut = function (id) {
        $.put("/updateProcess")
    }
</script>
<body>
<jsp:include page="/WEB-INF/pages/navigation.jsp"/>
<div class="container">
    <form:form id="updateForm" modelAttribute="user" action="../updateProcess">
        <table>
            <tr>
                <td>
                    <input type="hidden" id="id" name="id" value="${user.id}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="login"><spring:message code="edit.lable.login"/></form:label>
                </td>
                <td>
                    <form:input path="login" name="login" id="login"/>
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
                    <button onclick="RestPut()"><spring:message code="edit.button.confirm"/></button>
                </td>
            </tr>
            <tr>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
