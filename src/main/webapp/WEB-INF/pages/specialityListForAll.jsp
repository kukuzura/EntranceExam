<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="speciality-card">
<head>
    <title><sping:message key="specialityList.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="pictured">
<sec:authorize access="!isAuthenticated()">
    <jsp:include page="mainNavigation.jsp"/>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <jsp:include page="accountNvigation.jsp"/>
</sec:authorize>
<div class="container group">
    <c:forEach items="${specialityList}" var="speciality">
        <div class="grid-1-5">
            <h2 class="speciality-card-h2">${speciality.name}</h2>
            <ul>
                <c:forEach items="${speciality.exams}" var="exam">
                    <p>${exam.subject.name}</p>
                </c:forEach>
            </ul>
            <c:choose>
            <c:when test="${speciality.test==true}">
                <a href="<c:url value = "/account/applyWithTest/${speciality.id}"/>" class="button-apply"><sping:message
                        key="specialityList.button.apply"/></a>
            </c:when>
            <c:otherwise>
            <a href="<c:url value = "/account/apply/${speciality.id}"/>" class="button-apply"><sping:message
                    key="specialityList.button.apply"/></a>
            </c:otherwise>
            </c:choose>
        </div>
    </c:forEach>
</div>
</body>
</html>
