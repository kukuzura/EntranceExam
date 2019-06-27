<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Exam List</title>
    <link rel="stylesheet" href="/resources/css/userList.css"/>
</head>
<body>
<table id="list">
    <tr>
        <th>Id</th>
        <th>Teacher</th>
        <th>Subject</th>
        <th>Speciality</th>
        <th></th>
    </tr>
    <c:forEach items="${examList}" var="exam">
        <tr>
            <td align="center">${exam.id}</td>
            <td align="center">${exam.teacher.lastName} ${exam.teacher.lastName} ${exam.teacher.lastName}</td>
            <td align="center">${exam.subject.name}</td>
            <td align="center">${exam.speciality.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
