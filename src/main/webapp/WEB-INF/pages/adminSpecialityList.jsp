<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSpecialityList.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="table">
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div class="table-container">
    <table id="list">
        <tr>
            <th><spring:message key="adminSpecialityList.label.id"/></th>
            <th><spring:message key="adminSpecialityList.label.name"/></th>
        </tr>
        <c:forEach items="${specialityList}" var="speciality">
            <tr>
                <td align="center">${speciality.id}</td>
                <td align="center">${speciality.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
