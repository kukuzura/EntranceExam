<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="teacherRegistration.title"/></title>
    <link rel="stylesheet" href="/resources/css/registration.css"/>
</head>
<body>
<jsp:include page="/WEB-INF/pages/navigation.jsp"/>
<div class="container">
    <h1><spring:message code="teacherRegistration.title"/></h1>
    <form method="post">
        <table>
            <tr>
                <td>
                    <label><spring:message code="teacherRegistration.lable.login"/></label>
                </td>
                <td>
                    <input type="text" name="login"/>
                </td>
                <td>
                    <form:errors path="user.login" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label><spring:message code="teacherRegistration.lable.password"/></label>
                </td>
                <td>
                    <input type="password" name="password"/>
                </td>
                <td>
                    <form:errors path="user.password" cssClass="error"/>
                </td
            </tr>
            <tr>
                <td>
                    <label><spring:message code="teacherRegistration.lable.firstName"/></label>
                </td>
                <td>
                    <input type="text" name="firstName"
                           placeholder="<spring:message code="teacherRegistration.placeholder.firstName"/>"/>
                </td>
                <td>
                    <form:errors path="teacher.firstName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label><spring:message code="teacherRegistration.lable.lastName"/></label>
                </td>
                <td>
                    <input type="text" name="lastName"
                           placeholder="<spring:message code="teacherRegistration.placeholder.lastName"/>"/>
                </td>
                <td>
                    <form:errors path="teacher.lastName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label><spring:message code="teacherRegistration.lable.patronymic"/></label>
                </td>
                <td>
                    <input type="text" name="patronymic"
                           placeholder="<spring:message code="teacherRegistration.placeholder.patronymic"/>"/>
                </td>
                <td>
                    <form:errors path="teacher.patronymic" cssClass="error"/>
                </td>

            <tr>
                <td>
                    <a style="color: #6c757d ; margin: 10px" href="/login">Already have an account</a>
                    <button><spring:message code="teacherRegistration.button.confirm"/></button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
