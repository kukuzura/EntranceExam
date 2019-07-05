<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
    <title><spring:message key="login.title"/></title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T">
    <link rel="stylesheet" href="/resources/css/registration.css"/>
</head>

<body>
<div class="container">
    <div class="form-group">
        <form:form method="post">
            <h2><spring:message key="login.title"/></h2>
                <c:if test="${not empty error}">
                    <span class="login-error" align="center" class="error">${error}</span>
                </c:if>
                <p>
                    <label for="login" class="floatLabel"><spring:message key="login.lable.login"/></label>
                    <input type="text" name="login" id="login"/>
                </p>
                <p>
                    <label for="password" class="floatLabel"><spring:message key="login.lable.password"/></label>
                    <input type="password" name="password" id="password"/>
                </p>
            <input type="submit" value="<spring:message key="login.button.confirm"/>" id="submit">
        </form:form>
    </div>
</div>
</body>
</html>
