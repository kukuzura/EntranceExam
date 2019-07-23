<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Speciality List</title>
</head>
<body>
<table id="list">
    <tr>
        <th width="50">ID</th>
        <th width="80">Name</th>
        <th width="50"></th>
    </tr>
    <c:forEach items="${specialityList}" var="speciality">
        <tr>
            <td align="center">${speciality.id}</td>
            <td align="center">${speciality.name}</td>
            <td>
                <a href="/admin/specialityDelete/${speciality.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <a href="/admin/addSpeciality">Add speciality</a>
</table>
</body>
</html>
