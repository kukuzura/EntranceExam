<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="head.jsp"/>
<ul class="main-navigation">
    <li><a href="<c:url value="/"/>"><spring:message code="teacherNavigation.button.home"/></a></li>
    <sec:authorize access="hasRole('ROLE_TEAHER')">
        <li><a href="<c:url value = "/account/teacherPage"/>"><spring:message
                code="teacherNavigation.button.teacherPage"/></a></li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_STUDENT')">
        <li><a href="<c:url value = "/account/studentPage"/>"><spring:message
                code="studentNavigation.button.studentPage"/></a></li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="<c:url value = "/admin/adminPage"/>"><spring:message
                code="adminPage.title"/></a></li>
    </sec:authorize>

    <li class="dropdown">
        <a class="dropbtn"><spring:message code="teacherNavigation.dropdown.name"/></a>
        <div class="dropdown-content">
            <a href="?lang=en"><spring:message code="teacherNavigation.dropdown.eng"/></a>
            <a href="?lang=RU_ru"><spring:message code="teacherNavigation.dropdown.rus"/></a>
        </div>
        <sec:authorize access="isAuthenticated()">
    <li class="logout"><a href="<c:url value = "/logout"/>"><spring:message code="teacherNavigation.button.logout"/></a>
    </li>
    </sec:authorize>
</ul>