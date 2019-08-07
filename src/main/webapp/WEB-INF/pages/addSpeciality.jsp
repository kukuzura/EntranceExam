<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="addSpeciality.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<form:form modelAttribute="speciality" method="post">
    <p><form:label path="name"><spring:message code="addSpeciality.label.name"/></form:label></p>
    <p><form:input path="name" name="name" id="name"/></p>
    <p><form:button id="submit" name="submit"><spring:message
            code="addSpeciality.button.confirm"/></form:button></p>
</form:form>
</body>
</html>
