<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="ratePage.title"/></title>
</head>
<body>
<input type="hidden" name="examID" value="${examID}">
<form:form method="post" action="/account/rate/${examID}" modelAttribute="studentForm">
    <table id="list">
        <tr>
            <th><spring:message key="ratePage.lable.passportID"/></th>
            <th><spring:message key="ratePage.lable.lastName"/></th>
            <th><spring:message key="ratePage.lable.firstName"/></th>
            <th><spring:message key="ratePage.lable.patronymic"/></th>
            <th><spring:message key="ratePage.lable.grade"/></th>
        </tr>
        <c:forEach items="${studentForm.students}" var="student" varStatus="status">
            <tr>
                    <form:input type="hidden" path="students[${status.index}].id" name="id" id="id" value=""
                                readonly="true"/>
                <td>
                    <form:input path="students[${status.index}].passportID" readonly="true"/>
                </td>
                <td>
                    <form:input path="students[${status.index}].lastName" name="lastName" id="lastName" value=""
                                readonly="true"/>
                </td>
                <td>
                    <form:input path="students[${status.index}].firstName" name="lastName" id="lastName" value=""
                                readonly="true"/>
                </td>
                <td>
                    <form:input path="students[${status.index}].patronymic" name="lastName" id="lastName" value=""
                                readonly="true"/>
                </td>
                <td>
                    <form:input path="students[${status.index}].grade" name="grade" id="grade" value=""/>
                </td>
            <tr></tr>
        </c:forEach>
        <input type="submit" value="<spring:message key="ratePage.button.submit"/>">
    </table>
</form:form>
</body>
</html>
