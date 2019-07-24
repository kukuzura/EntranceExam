<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="addSubject.title"/></title>
</head>
<body>
<form:form modelAttribute="subject" method="post">
    <table>
        <tr>
            <td>
                <form:label path="name"><spring:message key="addSubject.label.name"/></form:label>
            </td>
            <td>
                <form:input path="name" name="name" id="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:button id="submit" name="submit"><spring:message key="addSubject.button.confirm"/></form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>