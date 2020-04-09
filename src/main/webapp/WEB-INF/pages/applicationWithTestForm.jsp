<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Apply</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<form:form modelAttribute="studentInfo" method="post">
    <c:forEach items="${studentInfo.grades}" var="grade" varStatus="status">
        <form:input type="hidden" path="grades[${status.index}].examId"/>
        <form:input path="grades[${status.index}].subjectName" readonly="true"/>
<%--        <label><spring:message key="${items[${status.index}].subjectName}"/></label>--%>
        <form:input path="grades[${status.index}].grade"/>

    </c:forEach>
    <form:button class="rate-button"><spring:message key="ratePage.button.submit"/></form:button>
</form:form>
</body>
</html>
