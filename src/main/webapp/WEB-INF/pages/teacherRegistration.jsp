<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="teacherRegistration.title"/></title>
    <link rel="stylesheet" href="/resources/css/registration.css"/>
</head>
<body>
<div class="container">
    <div class="form-group">
        <form method="post">
            <h2><spring:message code="teacherRegistration.title"/></h2>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.login"/></label>
                <input type="text" name="login"/>
                <span><form:errors path="user.login"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.password"/></label>
                <input type="password" name="password"/>
                <span><form:errors path="user.password"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.firstName"/></label>
                <input type="text" name="firstName"
                       placeholder="<spring:message code="teacherRegistration.placeholder.firstName"/>"/>
                <span><form:errors path="teacher.firstName"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.lastName"/></label>
                <input type="text" name="lastName"
                       placeholder="<spring:message code="teacherRegistration.placeholder.lastName"/>"/>
                <span><form:errors path="teacher.lastName"/></span>
            </p>
            <p>
                <label class="floatLabel"><spring:message code="teacherRegistration.lable.patronymic"/></label>
                <input type="text" name="patronymic"
                       placeholder="<spring:message code="teacherRegistration.placeholder.patronymic"/>"/>
                <span><form:errors path="teacher.patronymic"/></span>
            </p>
            <a style="color: #6c757d ; margin: 10px" href="/login">Already have an account</a>
            <input type="submit" value="<spring:message code="teacherRegistration.button.confirm"/>"/>
        </form>
    </div>
</div>
</body>
</html>
