<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link rel="stylesheet" href="/resources/css/navigation.css"/>
</head>

<ul>
    <li><a href="/"><spring:message code="studentNavigation.button.home"/></a></li>
    <li><a href="<c:url value = ""/>"><spring:message code="studentNavigation.button.studentPage"/></a></li>
    <li><a href="<c:url value = ""/>"><spring:message code="studentNavigation.button.studentExamList"/></a></li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="studentNavigation.dropdown.name"/></a>
        <div class="dropdown-content">
            <a href="?lang=en"><spring:message code="studentNavigation.dropdown.eng"/></a>
            <a href="?lang=RU_ru"><spring:message code="studentNavigation.dropdown.rus"/></a>
        </div>
    <li class="logout"><a href="<c:url value = "/logout"/>"><spring:message code="studentNavigation.button.logout"/></a></li>
</ul>