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
<div>
    <table id="list">
        <tr>
            <th width="50"><spring:message code="userList.lable.Id"/></th>
            <th width="80"><spring:message code="userList.lable.login"/></th>
            <th width="80"><spring:message code="userList.lable.password"/></th>
            <th width="50"></th>
            <th width="50"></th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr id=${user.id}>
                <td align="center">${user.id}</td>
                <td align="center">${user.login}</td>
                <td align="center">${user.password}</td>
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
</body>
</html>
