<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <jsp:include page="/WEB-INF/pages/head.jsp"/>
</head>

<body class="error-page-404">
<div class="text-left">
    <h1 align="center">404</h1>
    <h3 align="center">Page not found</h3>
    <p><a href="<c:url value="/"/>">Back to homepage</a></p>
</div>
<div class="astronaut-image">
    <img src="<c:url value="/resources/images/image.png"/>"/>
</div>
</body>
</html>
