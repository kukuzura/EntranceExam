<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="teacherRegistration.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="registration-and-login">
<div class="container">
    <div class="form-group">
        <form method="post">
            <h2><spring:message code="teacherRegistration.title"/></h2>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.login"/></label>
                <form:input type="text" name="login" path="user.login"/>
                <span><form:errors path="user.login"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.password"/></label>
                <form:input type="password" name="password" path="user.password"/>
                <span><form:errors path="user.password"/></span>
            </p>
            <p>
                <label for="confirm_password" class="floatLabel"><spring:message
                        code="studentRegistration.label.passwordConfirm"/></label>
                <input id="confirm_password" name="confirm_password" type="password"/>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.firstName"/></label>
                <form:input type="text" name="firstName" path="teacher.firstName"/>
                <span><form:errors path="teacher.firstName"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.lastName"/></label>
                <form:input type="text" name="lastName" path="teacher.lastName"/>
                <span><form:errors path="teacher.lastName"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.patronymic"/></label>
                <form:input type="text" name="patronymic" path="teacher.patronymic"/>
                <span><form:errors path="teacher.patronymic"/></span>
            </p>
            <a style="color: #6c757d ; margin: 10px" href="<c:url value="/login"/>">Already have an account</a>
            <input type="submit" onclick="validatePassword()" value="<spring:message code="teacherRegistration.button.confirm"/>"/>
        </form>
    </div>
</div>
</body>
</html>
