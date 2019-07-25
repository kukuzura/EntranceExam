<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="userList.title"/></title>
</head>

<style>
    <%@include file="/resources/css/table.css" %>
</style>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script>
    function RestGetUpdatePage(id) {
        $.ajax({
            type: "get",
            url: "/admin/userUpdate/"+id,
            data: id,
            success: function(){
                window.location.href="/admin/userUpdate/"+id;
            }
        })
    };
</script>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script>
    function RestDelete(id) {
        $.ajax({
            type: "DELETE",
            url: "/admin/userDelete/"+id,
            data: id,
            success: function(){
                window.location.href="/admin/userList";
            }
        })
    }
</script>

<body>
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div style="padding-top:30px;margin-top:30px;height:1500px;">
    <table id="list">
        <tr>
            <th width="50"><spring:message code="userList.lable.Id"/></th>
            <th width="80"><spring:message code="userList.lable.login"/></th>
            <th width="80"><spring:message code="userList.lable.password"/></th>
            <th width="50"></th>
            <th width="50"></th>
        </tr>
        <c:forEach items="${usersList}" var="user">
            <tr>
                <td align="center">${user.id}</td>
                <td align="center">${user.login}</td>
                <td align="center">${user.password}</td>
                <td>
                    <button onclick="RestGetUpdatePage(${user.id})"><spring:message
                            code="userList.button.edit"/></button>
                </td>
                <td>
                    <button onclick="RestDelete(${user.id})"><spring:message
                            code="userList.button.delete"/></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
