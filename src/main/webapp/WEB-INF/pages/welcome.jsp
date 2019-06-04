<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Welcome</title>
</head>
<body>
<table>
    <tr>
        <td>Welcome ${login}</td>
    </tr>
    <tr>
    </tr>
    <tr>
    </tr>
    <tr>
        <td><a href="<c:url value='..' />"><spring:message code="homePage"/></a>
        </td>
    </tr>
</table>
</body>
</html>

