<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSpecialityList.title"/></title>
</head>
<body>
<table id="list">
    <tr>
        <th width="50"><spring:message key="adminSpecialityList.label.id"/></th>
        <th width="80"><spring:message key="adminSpecialityList.label.name"/></th>
        <th width="50"></th>
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
    <a href="/admin/addSpeciality"><spring:message key="adminSpecialityList.button.addSpeciality"/></a>
</table>
</body>
</html>
