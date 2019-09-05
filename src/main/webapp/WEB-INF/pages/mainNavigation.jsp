<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<ul class="main-navigation">
    <li><a href="<c:url value="/"/>"><spring:message code="home.navigation.button.home"/></a></li>
    <li><a href="<c:url value = "/specialityList"/>"><spring:message
            code="home.navigation.button.speciality"/> </a>
    </li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="home.navigation.dropdown.registration"/> </a>
        <div class="dropdown-content">

            <a href="<c:url value = "/studentRegister"/>"><spring:message
                    code="home.navigation.button.studentRegistration"/></a>
            <a href="<c:url value = "/teacherRegister"/>"><spring:message
                    code="home.navigation.button.teacherRegistration"/></a>
        </div>
        <sec:authorize access="isAnonymous()">
    <li><a href="<c:url value = "/login"/>"><spring:message
            code="home.navigation.button.login"/> </a></li>
    </sec:authorize>
    <li><a href="<c:url value = "/about"/>"><spring:message code="home.navigation.button.about"/> </a></li>
    <sec:authorize access="hasRole('ROLE_TEACHER')">
        <li><a href="<c:url value = "/account/teacherPage"/>"><spring:message
                code="home.navigation.teacherPage"/> </a></li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_STUDENT')">
        <li><a href="<c:url value = "/account/studentPage"/>"><spring:message
                code="home.navigation.studentPage"/> </a></li>
    </sec:authorize>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="home.navigation.dropdown.locale"/> </a>
        <div class="dropdown-content">
            <a href="<c:url value = "?lang=en_US"/>"><spring:message code="home.navigation.button.locale_en"/> </a>
            <a href="<c:url value = "?lang=ru_RU"/>"><spring:message code="home.navigation.button.locale_ru"/> </a>
        </div>
        <sec:authorize access="isAuthenticated()">
    <li class="logout"><a href="<c:url value="/logout"/>"><spring:message code="navigation.button.logout"/></a>
    </li>
    </sec:authorize>
</ul>
