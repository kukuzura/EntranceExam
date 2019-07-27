<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="examList.title"/></title>
    <link rel="stylesheet" href="/resources/css/table.css"/>
    <link rel="stylesheet" href="/resources/css/link.css"/>
</head>
<body>
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div style="padding-top:30px;margin-top:30px;height:1500px;">
<table id="list">
    <tr>
        <th><spring:message code="examList.label.id"/></th>
        <th><spring:message code="examList.label.teacher"/></th>
        <th><spring:message code="examList.label.subject"/></th>
        <th><spring:message code="examList.label.speciality"/></th>
        <th></th>
    </tr>
    <c:forEach items="${examList}" var="exam">
        <tr>
            <td align="center">${exam.id}</td>
            <td align="center">${exam.teacher.lastName} ${exam.teacher.lastName} ${exam.teacher.lastName}</td>
            <td align="center">${exam.subject.name}</td>
            <td align="center">${exam.speciality.name}</td>
            <td><a href="<c:url value='/admin/examDelete/${exam.id}'/>"><spring:message code="examList.button.delete"/></a></td>
        </tr>
        <tr></tr>
    </c:forEach>
</table>
<div align="center" >
<a  href="/admin/addExam"><spring:message code="addingExam.button.addExam"/></a>
</div>
</div>
</body>
</html>
