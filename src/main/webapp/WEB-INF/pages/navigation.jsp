<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style><%@include file="/resources/css/navigation.css" %></style>

<ul>
    <li><a href="/"><spring:message code="home.button.home"/></a></li>
    <li><a href="<c:url value = "/admin/userList"/>"><spring:message code="home.button.listOfUsers"/></a></li>
    <li><a href="<c:url value = "/login"/>"><spring:message code="home.button.login"/></a></li>
    <li><a href="<c:url value = "/studentRegister"/>"><spring:message code="home.button.registration"/></a></li>
    <li><a href=""><spring:message code="home.button.about"/></a></li>
</ul>