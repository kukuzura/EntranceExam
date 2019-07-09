<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Speciality List</title>
    <link rel="stylesheet" href="/resources/css/userList.css"/>
    <link rel="stylesheet" href="/resources/css/link.css"/>
</head>
<body>
<div style="padding-top:30px;margin-top:30px;height:1500px;">
    <table id="list">
        <c:forEach items="${specialityList}" var="speciality">
            <tr>
                <td align="center">${speciality.name}</td>
                <td>
                    <c:forEach items="${speciality.exams}" var="exam">
                    <p>${exam.subject.name}</p>
                    </c:forEach>
                </td>
                <td><a href="<c:url value='/account/apply/${speciality.id}' />">Apply</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
