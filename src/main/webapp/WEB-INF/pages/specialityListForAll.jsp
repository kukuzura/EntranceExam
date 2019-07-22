<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sping:message key="specialityList.title"/></title>
    <link rel="stylesheet" href="/resources/css/specialityCard.css"/>
</head>
<div class="container group">
    <c:forEach items="${specialityList}" var="speciality">
        <div class="grid-1-5">
            <h2>${speciality.name}</h2>
            <ul>
                <c:forEach items="${speciality.exams}" var="exam">
                    <p>${exam.subject.name}</p>
                </c:forEach>
            </ul>
            <a href="/account/apply/${speciality.id}" class="button"><sping:message
                    key="specialityList.button.apply"/></a>
        </div>
    </c:forEach>
</div>
</html>
