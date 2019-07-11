<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <jsp:include page="/WEB-INF/pages/teacherNavigator.jsp/"/>
    <title><spring:message code="teacherPage.title"/></title>
</head>

<body>
<h3><spring:message code="teacherPage.lable.lastName"/> ${teacher.lastName}</h3>
<h3><spring:message code="teacherPage.lable.firstName"/>${teacher.firstName}</h3>
<h3><spring:message code="teacherPage.lable.patronymic"/>${teacher.patronymic}</h3>
<h2><spring:message code="studentPage.lable.exams"/></h2>
<table>
    <tr>
        <th width="50"><spring:message code="teacherPage.lable.speciality"/></th>
        <th width="80"><spring:message code="teacherPage.lable.subject"/></th>
    </tr>
    <c:forEach items="${examList}" var="exam">
        <tr>
            <td>
                <p>${exam.speciality.name}</p>
            </td>
            <td>
                <p>${exam.subject.name}</p
            </td>
            <td>
                <a href="rate/${exam.id}"><spring:message code="teacherPage.button.grading"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>












