<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSubjectList.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="table">
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div class="table-container">
    <table id="list">
        <tr>
            <th><spring:message key="adminSubjectList.label.id"/></th>
            <th><spring:message key="adminSubjectList.label"/></th>
            <th></th>
        </tr>
        <c:forEach items="${subjectList}" var="subject">
            <tr>
                <td align="center">${subject.id}</td>
                <td align="center">${subject.name}</td>
                <td>
                    <a class="simple-link" href="<c:url value="/admin/subjectDelete/${subject.id}"/>"><spring:message
                            key="adminSubjectList.button.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
