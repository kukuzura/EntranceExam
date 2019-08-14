<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <title><spring:message code="adminPage.title"/></title>
    <jsp:include page="head.jsp"/>
</head>

<body>
<jsp:include page="/WEB-INF/pages/adminNavigation.jsp"/>
<div class="admin-gif">
    <img src="<c:url value="/resources/images/linn-7757.gif"/>"/>
</div>
</body>

</html>












