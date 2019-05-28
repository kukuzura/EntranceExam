<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>

<table align="center">
        <tr>
            <th width="50">ID</th>
            <th width="80">Login</th>
            <th width="80">Password</th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td align = "center">${user.id}</td>
                <td align = "center">${user.login}</td>
                <td align = "center">${user.password}</td>
                <td><a href="<c:url value='/userUpdate/${user.id}' />" >Edit</a></td>
            </tr>
        </c:forEach>
    <td></td>
    <td><a href="..">Home</a>
    </td>
    </table>
</body>
</html>
