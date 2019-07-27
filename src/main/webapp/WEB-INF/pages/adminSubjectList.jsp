<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSubjectList.title"/></title>
    <link rel="stylesheet" href="/resources/css/table.css"/>
    <link rel="stylesheet" href="/resources/css/link.css"/>
</head>
<body>
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div style="padding-top:30px;margin-top:30px;height:1500px;">
<table id="list">
    <tr>
        <th ><spring:message key="adminSubjectList.label.id"/></th>
        <th><spring:message key="adminSubjectList.label"/></th>
        <th></th>
    </tr>
    <c:forEach items="${subjectList}" var="subject">
        <tr>
            <td align="center">${subject.id}</td>
            <td align="center">${subject.name}</td>
            <td>
                <a href="/admin/subjectDelete/${subject.id}"><spring:message
                        key="adminSubjectList.label"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
    <a class="add_button" href="/admin/addSubject"><spring:message key="adminSubjectList.button.addSpeciality"/> </a>
</div>
</body>
</html>
