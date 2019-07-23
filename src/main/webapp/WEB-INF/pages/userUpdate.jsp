<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <style>
        <%@include file="/resources/css/login.css" %>
    </style>
    <title><spring:message code="edit.title"/></title>
</head>

<body>
<jsp:include page="/WEB-INF/pages/navigation.jsp"/>
<div class="container">
    <form id="editForm" modelAttribute="user">
        <table>
            <tr>
                <td>
                    <input type="hidden" id="id" name="id" value="${user.id}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="login"><spring:message code="edit.lable.login"/></label>
                </td>
                <td>
                    <input path="login" type="text" id="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="password"><spring:message code="edit.lable.password"/></label>
                </td>
                <td>
                    <input path="password" type="password" id="password"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" id="submit" value="<spring:message code="edit.button.confirm"/>"/>
                </td>
            </tr>
            <tr>
            </tr>
        </table>
    </form>
</div>
<script>
    $(document).ready(function () {
        $('#editForm').submit(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'PUT',
                url: '/updateProcess',
                data : $(this).attr('user'),
                success: function () {
                    window.location.href='/admin/updateProcess'
                }

            });
        });
    });
</script>
</body>
</html>
