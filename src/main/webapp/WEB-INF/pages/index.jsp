<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><spring:message code="home.title"/></title>
</head>

<style>
    <%@include file="/WEB-INF/pages/css/navigation.css" %>
</style>

<body>
<table align="center">
    <ul>
        <li><a class="active" href="/">Home</a></li>
        <li><a href="<c:url value = "/userList"/>">User List</a></li>
        <li><a href="<c:url value = "/login"/>">Login</a></li>
        <li><a href="<c:url value = "/studentRegister"/>">Registration</a></li>
        <li><a href="">About</a></li>
    </ul>
</table>

Current Locale : ${pageContext.response.locale}

</body>

</html>












