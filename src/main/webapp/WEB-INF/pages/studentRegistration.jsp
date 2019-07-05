<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>

<head>
    <title><spring:message code="studentRegistration.title"/></title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T">
</head>


<body>
<div class="container">
    <div class="form-group">
        <form method="post">
            <h2><spring:message code="studentRegistration.title"/></h2>
            <p>
                <label for="login" class="floatLabel"><spring:message code="studentRegistration.lable.login"/></label>
                <input id="login" name="login" type="text"/>
                <span><form:errors path="user.login"/></span>
            </p>
            <p>
                <label for="password" class="floatLabel"><spring:message code="studentRegistration.lable.password"/></label>
                <input id="password" name="password" type="password">
                <span><form:errors path="user.password"/></span>
            </p>
            <p>
                <label for="firstName" class="floatLabel"><spring:message code="studentRegistration.lable.firstName"/></label>
                <input id="firstName" name="firstName" type="password">
                <span><form:errors path="student.firstName"/></span>
            </p>
            <p>
                <label for="lastName" class="floatLabel"><spring:message code="studentRegistration.lable.lastName"/></label>
                <input id="lastName" name="lastName" type="password">
                <span><form:errors path="student.lastName"/></span>
            </p>
            <p>
                <label for="patronymic" class="floatLabel"><spring:message code="studentRegistration.lable.patronymic"/></label>
                <input id="patronymic" name="patronymic" type="password">
                <span><form:errors path="student.patronymic"/></span>
            </p>
            <p>
                <label for="passportID" class="floatLabel"><spring:message code="studentRegistration.lable.passportID"/></label>
                <input id="passportID" name="passportID" type="password">
                <span><form:errors path="student.patronymic"/></span>
            </p>
            <p>
                <input type="submit" value="<spring:message code="studentRegistration.button.confirm"/>" id="submit">
            </p>
        </form>
    </div>
</div>
</body>

</html>
<style>

    <%@include file="/resources/css/errors.css" %>
    <%@include file="/resources/css/registration.css" %>
</style>
