<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="addingExam.title"/></title>
    <link rel="stylesheet" href="/resources/css/link.css"/>
</head>
<body>
<form:form method="post" commandName="exam">
    <table>
        <tr>
            <td>
                <label><spring:message code="addingExam.label.speciality"/></label>
            </td>
            <td>
                <form:select path="speciality">
                    <form:options items="${specialityList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <label><spring:message code="addingExam.label.subject"/></label>
            </td>
            <td>
                <form:select path="subject">
                    <form:options items="${subjectList}" itemValue="id" itemLabel="name"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <label><spring:message code="addingExam.label.teacher"/></label>
            </td>
            <td>
                <form:select path="teacher">
                    <form:options items="${teacherList}" itemValue="id" itemLabel="lastName"/>
                </form:select>
            </td>
            <button><spring:message code="addingExam.button.confirm"/></button>
    </table>
</form:form>
</body>
</html>
