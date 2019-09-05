<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
    <title><spring:message code="studentRegistration.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="registration-and-login">
<jsp:include page="mainNavigation.jsp"/>
<div class="container">
    <div class="form-group">
        <form id="registrationForm" name="registrationForm" method="post">
            <h2><spring:message code="studentRegistration.title"/></h2>
            <p>
                <label for="login" class="floatLabel"><spring:message code="studentRegistration.lable.login"/></label>
                <form:input id="login" name="login" type="text" path="user.login"/>
                <span><form:errors path="user.login"/></span>
            </p>
            <p>
                <label for="password" class="floatLabel"><spring:message
                        code="studentRegistration.lable.password"/></label>
                <form:input id="password" name="password" type="password" path="user.password"/>
                <span><form:errors path="user.password"/></span>
            </p>
            <p>
                <label for="confirm_password" class="floatLabel"><spring:message
                        code="studentRegistration.label.passwordConfirm"/></label>
                <input id="confirm_password" name="confirm_password" type="password"/>
            </p>
            <p>
                <label for="firstName" class="floatLabel"><spring:message
                        code="studentRegistration.lable.firstName"/></label>
                <form:input id="firstName" name="firstName" type="text" path="student.firstName"/>
                <span><form:errors path="student.firstName"/></span>
            </p>
            <p>
                <label for="lastName" class="floatLabel"><spring:message
                        code="studentRegistration.lable.lastName"/></label>
                <form:input id="lastName" name="lastName" type="text" path="student.lastName"/>
                <span><form:errors path="student.lastName"/></span>
            </p>
            <p>
                <label for="patronymic" class="floatLabel"><spring:message
                        code="studentRegistration.lable.patronymic"/></label>
                <form:input id="patronymic" name="patronymic" type="text" path="student.patronymic"/>
                <span><form:errors path="student.patronymic"/></span>
            </p>
            <p>
                <label for="passportID" class="floatLabel"><spring:message
                        code="studentRegistration.lable.passportID"/></label>
                <form:input id="passportID" name="passportID" type="text" path="student.passportID"/>
                <span><form:errors path="student.passportID"/></span>
            </p>
            <p>
                <a class="submit-register" style="text-decoration: underline" href="<c:out value="/login"/>">Already have an account?</a>
                <input type="submit" onclick="validatePassword()" value="<spring:message code="studentRegistration.button.confirm"/>" id="submit">
            </p>
        </form>
    </div>
</div>
</body>

</html>
