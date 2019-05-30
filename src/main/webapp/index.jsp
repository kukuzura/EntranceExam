<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>

<body>
<table align="center">
    <tr>
        <%--        <td><a href="login">Login</a>--%>
        <td><a href="<c:url value = "//login"/>">Login</a>
        </td>
        <%--    <td><a href="register">Register</a>--%>
        <td><a href="<c:url value = "//register"/>">Register</a>
        </td>
        <%--        <td><a href="userList">Users List</a>--%>
        <td><a href="<c:url value = "//userList"/>">Users List</a>
        </td>
    </tr>
</table>

</body>

</html>












