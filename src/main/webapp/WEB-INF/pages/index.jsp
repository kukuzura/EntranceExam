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
    <%@include file="/WEB-INF/pages/css/link.css" %>
</style>

<body>
<table align="center">
    <tr>
        <td><a href="<c:url value = "/login"/>"><spring:message code="home.button.login"/></a>
        </td>
        <td><a href="<c:url value = "/register"/>"><spring:message code="home.button.registration"/></a>
        </td>
        <td><a href="<c:url value = "/userList"/>"><spring:message code="home.button.listOfUsers"/></a>
        </td>
        <td><a href="<c:url value = "/studentRegister"/>">Student Register</a>
        </td>
    </tr>
</table>

Current Locale : ${pageContext.response.locale}

</body>

</html>












