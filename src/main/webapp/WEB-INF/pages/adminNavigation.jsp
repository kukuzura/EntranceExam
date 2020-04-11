<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <jsp:include page="head.jsp"/>
</head>

<ul class="main-navigation1">
    <li><a href="<c:url value="/"/>"><spring:message code="adminNavigation.button.home"/></a></li>
    <li><a href="<c:url value = "/admin/userList"/>"><spring:message
            code="adminNavigation.button.userList"/></a>
    </li>
    <li><a href="<c:url value = "/admin/examList"/>"><spring:message
            code="adminNavigation.button.examsList"/></a>
    </li>
    <li><a href="<c:url value = "/admin/specialityList"/>"><spring:message
            code="adminNavigation.button.specialityList"/></a></li>
    <li><a href="<c:url value = "/admin/subjectList"/>"><spring:message
            code="adminNavigation.button.subjectList"/></a></li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="adminNavigation.dropdown.name"/></a>
        <div class="dropdown-content">
            <a href="?lang=en_US"><spring:message code="adminNavigation.dropdown.eng"/></a>
            <a href="?lang=RU_ru"><spring:message code="adminNavigation.dropdown.rus"/></a>
        </div>
    <li class="logout"><a href="<c:url value = "/logout"/>"><spring:message
            code="adminNavigation.button.logout"/></a></li>
</ul>
