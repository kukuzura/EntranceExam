<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSubjectList.title"/></title>
</head>
<body>
<table id="list">
    <tr>
        <th width="50"><spring:message key="adminSubjectList.label.id"/></th>
        <th width="80"><spring:message key="adminSubjectList.label"/></th>
        <th width="50"></th>
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
    <a href="/admin/addSubject"><spring:message key="adminSubjectList.button.addSpeciality"/> </a>
</table>
</body>
</html>
