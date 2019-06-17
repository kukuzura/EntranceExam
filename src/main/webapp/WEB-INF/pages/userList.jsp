<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="home.button.listOfUsers"/></title>
</head>

<style>
    <%@include file="/WEB-INF/pages/css/userList.css" %>
    <%@include file="/WEB-INF/pages/css/link.css"%>
    <%@include file="/WEB-INF/pages/css/navigation.css"%>
</style>

<body>

    <ul>
        <li><a class="active" href="/">Home</a></li>
        <li><a href="<c:url value = "/userList"/>">User List</a></li>
        <li><a href="<c:url value = "/login"/>">Login</a></li>
        <li><a href="<c:url value = "/studentRegister"/>">Registration</a></li>
        <li><a href="">About</a></li>
    </ul>


<div style="padding-top:30px;margin-top:30px;height:1500px;">
<table id="users">
    <tr>
        <th width="50"><spring:message code="userList.lable.Id"/></th>
        <th width="80"><spring:message code="userList.lable.login"/></th>
        <th width="80"><spring:message code="userList.lable.password"/></th>
        <th width="50"></th>
        <th width="50"></th>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td align="center">${user.id}</td>
            <td align="center">${user.login}</td>
            <td align="center">${user.password}</td>
            <td><a href="<c:url value='/userUpdate/${user.id}' />"><spring:message code="userList.button.edit"/></a>
            </td>
            <td><a href="<c:url value='/userDelete/${user.id}' />"><spring:message code="userList.button.delete"/></a>
            </td>
        </tr>
    </c:forEach>
    <td></td>
</table>
<a href="<c:url value='..' />"><spring:message code="userList.button.home"/></a>
</div>
</body>
</html>
