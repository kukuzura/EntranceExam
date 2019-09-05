<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="userList.title"/></title>
    <jsp:include page="head.jsp"/>
    <jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
</head>
<body class="table">
<div class="table-container">
    <table id="list">
        <tr>
            <th><spring:message code="userList.lable.Id"/></th>
            <th><spring:message code="userList.lable.login"/></th>
            <th><spring:message code="userList.surname"/></th>
            <th><spring:message code="userList.label.name"/></th>
            <th><spring:message code="userList.patronymic"/></th>

            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr id=${user.id}>
                <td align="center">${user.id}</td>
                <td align="center">${user.login}</td>
            <c:choose>
                <c:when test="${empty user.teacher}">
                    <td align="center">${user.student.lastName}</td>
                    <td align="center">${user.student.firstName}</td>
                    <td align="center">${user.student.patronymic}</td>
                </c:when>
                <c:otherwise>
                    <td align="center">${user.teacher.lastName}</td>
                    <td align="center">${user.teacher.firstName}</td>
                    <td align="center">${user.teacher.patronymic}</td>
                </c:otherwise>
            </c:choose>
                <td>
                    <button class="table-button" onclick="RestGetUpdatePage(${user.id})"><spring:message
                            code="userList.button.edit"/></button>
                </td>
                <td>
                    <button class="table-button" onclick="RestDelete(${user.id})"><spring:message
                            code="userList.button.delete"/></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="page-numbers">
    <table>
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="<c:url value="/admin/userList?page=${i}"/>">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
</div>
</body>
</html>
