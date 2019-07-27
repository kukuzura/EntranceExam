<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message key="addSubject.title"/></title>
    <link rel="stylesheet" href="/resources/css/adding.css"/>
</head>
<body>
<form:form modelAttribute="subject" method="post">
    <label><form:label path="name"><spring:message key="addSubject.label.name"/></form:label></label>
    <p><form:input path="name" name="name" id="name"/></p>
    <p><form:button id="submit" name="submit"><spring:message key="addSubject.button.confirm"/></form:button></p>
</form:form>
</body>
</html>