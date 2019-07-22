<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <title><spring:message code="home.title"/></title>
    <link rel="stylesheet" href="/resources/css/home.css"/>
    <link rel="stylesheet" href="/resources/css/navigation.css"/>
</head>

<body>
<ul>
    <li><a href="/"><spring:message code="home.navigation.button.home"/></a></li>
    <li><a href="<c:url value = "/specialityList"/>"><spring:message code="home.navigation.button.speciality"/> </a>
    </li>
    <li class="dropdown nav">
        <a class="dropbtn"><spring:message code="home.navigation.dropdown.registration"/> </a>
        <div class="dropdown-content">
            <a href="/studentRegister"><spring:message code="home.navigation.button.studentRegistration"/></a>
            <a href="/teacherRegister"><spring:message code="home.navigation.button.teacherRegistration"/></a>
        </div>
    <li><a href="<c:url value = "/login"/>"><spring:message code="home.navigation.button.login"/> </a></li>
    <li><a href="<c:url value = "/about"/>"><spring:message code="home.navigation.button.about"/> </a></li>
    <li class="dropdown nav">
        <a class="dropbtn"><spring:message code="home.navigation.dropdown.locale"/> </a>
        <div class="dropdown-content">
            <a href="?lang=en_US"><spring:message code="home.navigation.button.locale_en"/> </a>
            <a href="?lang=ru_RU"><spring:message code="home.navigation.button.locale_ru"/> </a>
        </div>
</ul>
<input type="radio" id="trigger1" name="slider">
<label for="trigger1"></label>
<div class="slide bg1">
    <div class="title">
        <h1><spring:message code="home.navigation.text.tab1.h1"/></h1>
        <h2><spring:message code="home.navigation.text.tab1.h2"/></h2>
    </div>
    <div>
        <p class="description">Information for Prospective Majors
            The Ohio State Department of Astronomy offers an excellent Bachelor of Science degree in Astronomy and
            Astrophysics. This program provides superb preparation for students who plan to pursue graduate study and
            become professional astronomers and astrophysicists, as well as a diverse array of other graduate and
            professional programs.

            Our students obtain a strong background in physics and applied mathematics, and take courses in programming
            and data analysis, in addition to topics in modern astrophysics. The recommended curriculum includes a
            complete list of the required courses and various options for electives. This coursework teaches important
            critical thinking and problem solving skills, as well as the mathematical, statistical, and programming
            methods that are at the heart of most technical fields. Many graduates of our program have pursued graduate
            research in astronomy or physics, and many others have pursued a variety of careers including in software
            development, science writing, research scientist positions in industry, and secondary education.

            Students often get involved in undergraduate research, either in astronomy and astrophysics, or in a related
            department such as physics, chemistry, and math. Our faculty are very active researchers, and most work with
            undergraduate students (and graduate students) on research projects, in addition to teaching classes. The
            best way to get involved with research in the department is through our Summer Undergraduate Research
            Program. There are also numerous other opportunities to conduct research at other departments and
            observatories around the country and even around the world.

            There are also many other ways to get involved with the activities in the Department of Astronomy. One great
            way is through our morning Astronomy Coffee that meets daily at 10:30am in 4054 McPherson. There is also a
            weekly Astronomy Colloquium, the weekly Center for Cosmology and Astroparticle Physics (CCAPP) seminar,
            activities organized by the undergraduate Ohio State Astronomical Society, a public lecture series, and many
            other events. Please contact the Director of Undergraduate Studies if you are interested in a major or minor
            in astronomy and astrophysics.
        <p>

            <a class="link" href="/specialityList">Speciality List</a>

    </div>
</div>

<input type="radio" id="trigger2" name="slider" checked autofocus>
<label for="trigger2"></label>
<div class="slide bg3">
    <div>
        <div class="title">
            <h1><spring:message code="home.navigation.text.tab2.h1"/></h1>
            <h2><spring:message code="home.navigation.text.tab2.h2"/></h2>
        </div>
    </div>
</div>

<input type="radio" id="trigger3" name="slider">
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












