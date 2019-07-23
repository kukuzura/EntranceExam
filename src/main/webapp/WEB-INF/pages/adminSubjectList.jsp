<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Subject List</title>
</head>
<body>
<table id="list">
    <tr>
        <th width="50">ID</th>
        <th width="80">Name</th>
        <th width="50"></th>
    </tr>
    <c:forEach items="${subjectList}" var="subject">
        <tr>
            <td align="center">${subject.id}</td>
            <td align="center">${subject.name}</td>
            <td>
                <a href="/admin/subjectDelete/${subject.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/admin/addSubject">Add subject</a>
</table>
</body>
</html>
