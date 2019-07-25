<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSpecialityList.title"/></title>
    <link rel="stylesheet" href="/resources/css/table.css"/>
    <link rel="stylesheet" href="/resources/css/link.css"/>
</head>
<body>
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div style="padding-top:30px;margin-top:30px;height:1500px;">
<table id="list">
    <tr>
        <th><spring:message key="adminSpecialityList.label.id"/></th>
        <th><spring:message key="adminSpecialityList.label.name"/></th>
        <th></th>
    </tr>
    <c:forEach items="${specialityList}" var="speciality">
        <tr>
            <td align="center">${speciality.id}</td>
            <td align="center">${speciality.name}</td>
            <td>
                <a href="/admin/specialityDelete/${speciality.id}"><spring:message
                        key="adminSpecialityList.button.delete"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
    <a href="/admin/addSpeciality"><spring:message key="adminSpecialityList.button.addSpeciality"/></a>
</div>
</body>
</html>
