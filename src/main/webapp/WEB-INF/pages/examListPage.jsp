<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title><spring:message code="examList.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="table">
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div class="table-container">
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
            <td align="center">${exam.teacher.lastName} ${exam.teacher.firstName} ${exam.teacher.patronymic}</td>
            <td align="center">${exam.subject.name}</td>
            <td align="center">${exam.speciality.name}</td>
            <td><a class="simple-link" href="<c:url value='/admin/examDelete/${exam.id}'/>"><spring:message
                    code="examList.button.delete"/></a></td>
        </tr>
        <tr></tr>
    </c:forEach>
</table>
</div>
<div align="center" >
    <a class="simple-link add_button" href="<c:url value='/admin/addExam'/>"><spring:message code="addingExam.button.addExam"/></a>
</div>
</body>
</html>
