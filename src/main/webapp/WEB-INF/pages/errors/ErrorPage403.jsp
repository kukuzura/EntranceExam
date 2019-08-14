<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>403</title>
    <jsp:include page="../head.jsp"/>
   </head>
<body>
<div class="forbidden-error-page">
    <img src="<c:url value="/resources/images/illustration-lock-icon_53876-5633.jpg"/>">
    <h1>403</h1>
    <h3>Access to this page is restricted</h3>
    <p><a href="<c:url value="/"/>">Back to homepage</a></p>
</div>
</body>
</html>
