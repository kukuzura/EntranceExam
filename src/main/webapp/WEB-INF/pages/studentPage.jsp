<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <jsp:include page="/WEB-INF/pages/studentNavigation.jsp"/>
</head>

<body>
<h3>${student.lastName} ${student.firstName} ${student.patronymic}</h3>
<table>
    <c:forEach items="${examList}" var="exam">
        <tr>
            <td>
                <p>${exam.speciality.name}</p>
            </td>
            <td>
                <p>${exam.subject.name}</p>
            </td>
            <td>
                <p>${exam.teacher.lastName} ${exam.teacher.firstName} ${exam.teacher.patronymic}</p>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>












