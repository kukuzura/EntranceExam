<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sping:message key="specialityList.title"/></title>
    <link rel="stylesheet" href="/resources/css/userList.css"/>
    <link rel="stylesheet" href="/resources/css/link.css"/>
</head>
<body>
<div style="padding-top:30px;margin-top:30px;height:1500px;">
    <table id="list">
        <tr>
            <th><spring:message code="specialityList.lable.name"/></th>
            <th><spring:message code="specialityList.lable.subject"/></th>
            <th></th>
        </tr>
        <c:forEach items="${specialityList}" var="speciality">
            <tr>
                <td align="center">${speciality.name}</td>
                <td>
                    <c:forEach items="${speciality.exams}" var="exam">
                        <p>${exam.subject.name}</p>
                    </c:forEach>
                </td>
                <td><a href="<c:url value='/account/apply/${speciality.id}' />"><sping:message
                        key="specialityList.button.apply"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
