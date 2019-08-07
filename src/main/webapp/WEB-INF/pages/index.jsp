<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <title><spring:message code="home.title"/></title>
    <jsp:include page="head.jsp"/>
</head>

<body class="home">
<ul class="main-navigation">
    <li><a href="/"><spring:message code="home.navigation.button.home"/></a></li>
    <li><a href="<c:url value = "/specialityList"/>"><spring:message
            code="home.navigation.button.speciality"/> </a>
    </li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="home.navigation.dropdown.registration"/> </a>
        <div class="dropdown-content">

            <a href="<c:url value = "/studentRegister"/>"><spring:message
                    code="home.navigation.button.studentRegistration"/></a>
            <a href="<c:url value = "/teacherRegister"/>"><spring:message
                    code="home.navigation.button.teacherRegistration"/></a>
        </div>
    <li><a href="<c:url value = "/login"/>"><spring:message
            code="home.navigation.button.login"/> </a></li>
    <li><a href="<c:url value = "/about"/>"><spring:message code="home.navigation.button.about"/> </a></li>
    <li class="dropdown">
        <a class="dropbtn"><spring:message code="home.navigation.dropdown.locale"/> </a>
        <div class="dropdown-content">
            <a href="<c:url value = "?lang=en_US"/>"><spring:message code="home.navigation.button.locale_en"/> </a>
            <a href="<c:url value = "?lang=ru_RU"/>"><spring:message code="home.navigation.button.locale_ru"/> </a>
        </div>
</ul>


<input class="none-display" type="radio" id="trigger1" name="slider">
<label for="trigger1"></label>
<div class="slide bg1">
    <div class="title">
        <h1 class="home-main-title title"><spring:message code="home.navigation.text.tab1.h1"/></h1>
        <h2 class="title"><spring:message code="home.navigation.text.tab1.h2"/></h2>
    </div>
</div>

<input class="none-display" type="radio" id="trigger2" name="slider" checked autofocus>
<label for="trigger2"></label>
<div class="slide bg3">
    <div>
        <div class="title">
            <h1><spring:message code="home.navigation.text.tab2.h1"/></h1>
            <h2><spring:message code="home.navigation.text.tab2.h2"/></h2>
        </div>
    </div>
</div>

<input class="none-display"  type="radio" id="trigger3" name="slider">
<label for="trigger3"></label>
<div class="slide bg4">
    <div>
        <div class="title">
            <h1><spring:message code="home.navigation.text.tab3.h1"/></h1>
            <h2><spring:message code="home.navigation.text.tab1.h2"/></h2>
        </div>
    </div>
</div>


</body>

</html>












