<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style><%@include file="/resources/css/navigation.css" %></style>

<ul>
    <li><a href="/"><spring:message code="navigation.button.home"/></a></li>
    <li><a href="<c:url value = "/admin/userList"/>"><spring:message code="navigation.button.listOfUsers"/></a></li>
    <li><a href="<c:url value = "/login"/>"><spring:message code="navigation.button.login"/></a></li>
    <li><a href="<c:url value = "/studentRegister"/>"><spring:message code="navigation.button.registration"/></a></li>
    <li><a href=""><spring:message code="navigation.button.about"/></a></li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="navigation.dropdown.name"/></a>
        <div class="dropdown-content">
            <a href="?lang=en"><spring:message code="navigation.dropdown.eng"/></a>
            <a href="?lang=RU_ru"><spring:message code="navigation.dropdown.rus"/></a>
        </div>
</ul>