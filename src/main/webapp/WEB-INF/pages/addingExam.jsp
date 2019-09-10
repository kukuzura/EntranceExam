<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="addingExam.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="adding-page">
<div align="center">
    <form:form method="post" commandName="exam" action="${pageContext.request.contextPath}/admin/addExam">
        <label><spring:message code="addingExam.label.speciality"/></label>
        <div class="styled-select blue semi-square">
            <form:select path="speciality">
                <form:options items="${specialityList}" itemValue="id" itemLabel="name"/>
            </form:select>
        </div>
        <label><spring:message code="addingExam.label.subject"/></label>
        <div class="styled-select blue semi-square">
            <form:select path="subject">
                <form:options items="${subjectList}" itemValue="id" itemLabel="name"/>
            </form:select>
        </div>
        <label><spring:message code="addingExam.label.teacher"/></label>
        <div class="styled-select blue semi-square">
            <form:select path="teacher">
                <form:options items="${teacherList}" itemValue="id" itemLabel="lastName"/>
            </form:select>
        </div>
        <button class="add_button" style="margin-left: 1vh"><spring:message code="addingExam.button.confirm"/></button>
    </form:form>
</div>
</body>
</html>
