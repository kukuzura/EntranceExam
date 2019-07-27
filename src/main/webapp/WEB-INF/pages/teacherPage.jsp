<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <title><spring:message code="teacherPage.title"/></title>
    <link rel="stylesheet" href="/resources/css/studentPage.css">
    <link rel="stylesheet" href="/resources/css/table.css">
    <link rel="stylesheet" href="/resources/css/link.css">
</head>
<div class="tabs">
    <input type="radio" name="tabs" id="tabone" checked="checked">
    <label for="tabone"><spring:message code="teacherNavigation.button.teacherPage"/></label>
    <div class="tab">
        <div class="line first"><span class="label"><spring:message
                code="teacherPage.lable.lastName"/></span> ${teacher.lastName}</div>
        <div class="line"><span class="label"><spring:message
                code="teacherPage.lable.firstName"/></span> ${teacher.firstName}</div>
        <div class="line"><span class="label"><spring:message
                code="teacherPage.lable.patronymic"/></span> ${teacher.patronymic}
        </div>
    </div>

    <input type="radio" name="tabs" id="tabtwo">
    <label for="tabtwo"><spring:message code="teacherPage.lable.exams"/></label>
    <div class="tab">
        <table id="list">
            <c:choose>
                <c:when test="${empty examList}">
                    <tr><spring:message code="teacherPage.message.haveNoExam"/></tr>
                </c:when>
                <c:otherwise>
                    <tr>${message}</tr>
                    <tr>
                        <th><spring:message code="teacherPage.lable.speciality"/></th>
                        <th><spring:message code="teacherPage.lable.subject"/></th>
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
                                <a href="rate/${exam.id}"><spring:message code="teacherPage.button.grading"/></a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
    </div>

    <input type="radio" name="tabs" id="tabthree">
    <label for="tabthree">
        <div class="dropdown">
            <button class="dropbtn"><spring:message code="teacherPage.button.navigation"/></button>
            <div class="dropdown-content">
                <a href="/logout"> <spring:message code="teacherPage.button.logout"/></a>
                <a href="/"><spring:message code="teacherPage.button.home"/> </a>
            </div>
        </div>
    </label>

    <input type="radio" name="tabs" id="tabfour">
    <label for="tabfour">
        <div class="dropdown">
            <button class="dropbtn"><spring:message code="teacherPage.button.locale"/></button>
            <div class="dropdown-content">
                <a href="?lang=en_US"><spring:message code="teacherPage.button.locale.en"/></a>
                <a href="?lang=ru_Ru"><spring:message code="teacherPage.button.locale.ru"/></a>
            </div>
        </div>
    </label>
</div>
</html>












