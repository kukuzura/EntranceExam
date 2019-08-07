<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <jsp:include page="head.jsp"/>
</head>

<ul>
    <li><a href="/"><spring:message code="teacherNavigation.button.home"/></a></li>
    <li><a href="<c:url value = ""/>"><spring:message code="teacherNavigation.button.teacherPage"/></a></li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="teacherNavigation.dropdown.name"/></a>
        <div class="dropdown-content">
            <a href="?lang=en"><spring:message code="teacherNavigation.dropdown.eng"/></a>
            <a href="?lang=RU_ru"><spring:message code="teacherNavigation.dropdown.rus"/></a>
        </div>
    <li class="logout"><a href="<c:url value = "/logout"/>"><spring:message code="teacherNavigation.button.logout"/></a></li>
</ul>