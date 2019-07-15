<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="spting" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<%--<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>--%>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>

<%--<html>--%>

<%--<head>--%>
<%--    <jsp:include page="/WEB-INF/pages/studentNavigation.jsp"/>--%>
<%--    <title><spring:message code="studentPage.title"/></title>--%>
<%--</head>--%>

<%--<body>--%>

<%--<h3><spring:message code="studentPage.lable.lastName"/> ${student.lastName}</h3>--%>
<%--<h3><spring:message code="studentPage.lable.firstName"/> ${student.firstName}</h3>--%>
<%--<h3><spring:message code="studentPage.lable.patronymic"/> ${student.patronymic}</h3>--%>
<%--<h3><spring:message code="studentPage.lable.totalGrade"/> ${totalGrade}</h3>--%>

<%--<h2><spring:message code="studentPage.lable.exams"/></h2>--%>

<%--<table>--%>
<%--    <c:choose>--%>
<%--        <c:when test="${empty examList}">--%>
<%--            <tr><spring:message code="studentpage.message.haveNoExams"/></tr>--%>
<%--            <tr><a href="specialityList"><spring:message code="studentPage.button.apply"/></a></tr>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <tr>--%>
<%--                <th><spring:message code="studentPage.lable.speciality"/></th>--%>
<%--                <th><spring:message code="studentPage.lable.subject"/></th>--%>
<%--                <th><spring:message code="studentPage.lable.teacher"/></th>--%>
<%--                <th></th>--%>
<%--                <th></th>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${examList}" var="exam">--%>
<%--                <tr>--%>
<%--                    <td>--%>
<%--                        <p>${exam.speciality.name}</p>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <p>${exam.subject.name}</p>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <p>${exam.teacher.lastName} ${exam.teacher.firstName} ${exam.teacher.patronymic}</p>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</table>--%>

<%--</body>--%>
<%--</html>--%>


<!--

Radio version of tabs.

Requirements:
- not rely on specific IDs for CSS (the CSS shouldn't need to know specific IDs)
- flexible for any number of unkown tabs [2-6]
- accessible

Caveats:
- since these are checkboxes the tabs not tab-able, need to use arrow keys

Also worth reading:
http://simplyaccessible.com/article/danger-aria-tabs/
-->
<head>
    <link rel="stylesheet" href="/resources/css/studentPage.css">
    </head>


<div class="tabset">
    <input type="radio" name="tabset" id="tab1" aria-controls="marzen" checked>
    <label for="tab1">Student</label>
    <input type="radio" name="tabset" id="tab2" aria-controls="rauchbier">
    <label for="tab2">Exams</label>

    <div class="tab-panels">
        <section id="marzen" class="tab-panel">
            <h3><spring:message code="studentPage.lable.lastName"/> ${student.lastName}</h3>
            <h3><spring:message code="studentPage.lable.firstName"/> ${student.firstName}</h3>
            <h3><spring:message code="studentPage.lable.patronymic"/> ${student.patronymic}</h3>
            <h3><spring:message code="studentPage.lable.totalGrade"/> ${totalGrade}</h3>
        </section>
        <section id="rauchbier" class="tab-panel">
            <table>
                    <c:choose>
                        <c:when test="${empty examList}">
                            <tr><spring:message code="studentpage.message.haveNoExams"/></tr>
                            <tr><a href="specialityList"><spring:message code="studentPage.button.apply"/></a></tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <th><spring:message code="studentPage.lable.speciality"/></th>
                                <th><spring:message code="studentPage.lable.subject"/></th>
                                <th><spring:message code="studentPage.lable.teacher"/></th>
                                <th></th>
                                <th></th>
                            </tr>
                            <c:forEach items="${examList}" var="exam">
                                <tr>
                                    <td>
                                        <p>${exam.speciality.name}</p>
                                    </td>
                                    <td>
                                        <p>${exam.subject.name}</p>
                                    </td>
                                    <td>
                                        <p>${exam.teacher.lastName} ${exam.teacher.firstName} ${exam.teacher.patronymic}</p>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </table>
        </section>
    </div>

</div>









