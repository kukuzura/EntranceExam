<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title><spring:message code="edit.title"/></title>
</head>
<body class="registration-and-login">
<div class="container">
    <div class="form-group">
        <form:form id="editForm" modelAttribute="user">
            <input type="hidden" id="id" name="id" value="${user.id}"/>
            <p>
                <label for="login" class="floatLabel"><spring:message code="edit.lable.login"/></label>
                <form:input path="login" type="text" id="login"/>
            </p>
            <p>
                <label for="password" class="floatLabel"><spring:message
                        code="edit.lable.password"/></label>
                <input name="password" type="password" id="password"/>
            </p>
            <p>
                <input type="submit" id="submit" value="<spring:message code="edit.button.confirm"/>"/>
            </p>
        </form:form>
</div>
</div>
</body>
</html>
