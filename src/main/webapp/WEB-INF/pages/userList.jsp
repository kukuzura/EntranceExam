<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>

<table align="center">
        <tr>
            <th width="50"><spring:message code="Id"/></th>
            <th width="80"><spring:message code="login"/></th>
            <th width="80"><spring:message code="password"/></th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td align = "center">${user.id}</td>
                <td align = "center">${user.login}</td>
                <td align = "center">${user.password}</td>
                <td><a href="<c:url value='/userUpdate/${user.id}' />" ><spring:message code="editPage"/></a></td>
                <td><a href="<c:url value='/userDelete/${user.id}' />" ><spring:message code="deletePage"/></a></td>
            </tr>
        </c:forEach>
    <td></td>
    <td><a href="<c:url value='..' />"><spring:message code="homePage"/></a>
    </td>
    </table>
</body>
</html>
