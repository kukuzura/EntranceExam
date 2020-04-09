<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="adminSpecialityList.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="table">
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div class="table-container">
    <table id="list">
        <tr>
            <th><spring:message key="adminSpecialityList.label.id"/></th>
            <th><spring:message key="adminSpecialityList.label.name"/></th>
            <th></th>
        </tr>
        <c:forEach items="${specialityList}" var="speciality">
            <tr>
                <td align="center">${speciality.id}</td>
                <td align="center">${speciality.name}</td>
                <td>
                    <a class="simple-link"
                       href="<c:url value="/admin/specialityDelete/${speciality.id}"/>"><spring:message
                            key="adminSpecialityList.button.delete"/>
                    </a>
                    <c:if test="${speciality.test==true}">
                    <c:choose>
                    <c:when test="${speciality.entranceClosed==false}">
                        <a class="simple-link"
                           href="<c:url value="/admin/closeSpeciality/${speciality.id}"/>"><spring:message
                                key="adminSpecialityList.button.close"/>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a class="simple-link"
                           href="<c:url value="/admin/openSpeciality/${speciality.id}"/>"><spring:message
                                key="adminSpecialityList.button.open"/>
                        </a>
                    </c:otherwise>
                    </c:choose>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
