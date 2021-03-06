<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
    <title><spring:message key="login.title"/></title>
    <jsp:include page="head.jsp"/>
</head>

<body class="registration-and-login">
<jsp:include page="mainNavigation.jsp"/>
<div class="form-group">
    <form:form method="post">
        <h2><spring:message key="login.title"/></h2>
        <c:if test="${not empty error}">
            <span class="login-error" align="center" class="error">${error}</span>
        </c:if>
        <p>
            <label for="login" class="floatLabel"><spring:message key="login.lable.login"/></label>
        </p>
        <p>
            <input type="text" name="login" id="login"/>
        </p>
        <p>
            <label for="password" class="floatLabel"><spring:message key="login.lable.password"/></label>
        </p>
        <p>
            <input type="password" name="password" id="password"/>
        </p>
        <input type="submit" value="<spring:message key="login.button.confirm"/>" id="submit">
    </form:form>
</div>
</body>
</html>
