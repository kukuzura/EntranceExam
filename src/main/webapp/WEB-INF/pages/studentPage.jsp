<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <title><spring:message code="studentPage.title"/></title>
    <jsp:include page="head.jsp"/>
</head>
<body class="studentPage">
<div class="tabs">
    <input type="radio" name="tabs" id="tabone" checked="checked">
    <label for="tabone"><spring:message code="studentPage.title"/></label>
    <div class="tab">
        <div class="line first"><span class="label"><spring:message
                code="studentPage.lable.lastName"/></span> ${student.lastName}</div>
        <div class="line"><span class="label"><spring:message
                code="studentPage.lable.firstName"/></span> ${student.firstName}</div>
        <div class="line"><span class="label"><spring:message
                code="studentPage.lable.patronymic"/></span> ${student.patronymic}
        </div>
        <div class="line"><span class="label"><spring:message code="studentPage.lable.totalGrade"/></span> ${totalGrade}
        </div>
    </div>

    <input type="radio" name="tabs" id="tabtwo">
    <label for="tabtwo"><spring:message code="studentPage.lable.exams"/></label>
    <div class="tab">
        <table id="list">
            <c:choose>
                <c:when test="${empty examAndGradesMap}">
                    <tr><spring:message code="studentPage.message.haveNoExams"/></tr>
                    <tr><a href="specialityList"><spring:message code="studentPage.button.apply"/></a></tr>
                </c:when>
                <c:otherwise>
                    <tr>${message}</tr>
                    <tr>
                        <th><spring:message code="studentPage.lable.speciality"/></th>
                        <th><spring:message code="studentPage.lable.subject"/></th>
                        <th><spring:message code="studentPage.lable.teacher"/></th>
                        <th><spring:message code="studentPage.label.grade"/></th>
                    </tr>
                    <c:forEach items="${examAndGradesMap}" var="map">
                        <tr>
                            <td>
                                <p>${map.key.speciality.name}</p>
                            </td>
                            <td>
                                <p>${map.key.subject.name}</p>
                            </td>
                            <td>
                                <p>${map.key.teacher.lastName} ${map.key.teacher.firstName} ${map.key.teacher.patronymic}</p>
                            </td>
                            <td>
                                <p>${map.value}</p>
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
            <button class="dropbtn"><spring:message code="studentPage.button.navigation"/></button>
            <div class="dropdown-content">
                <a href="/logout"><spring:message code="studentPage.button.logout"/></a>
                <a href="/"><spring:message code="studentPage.button.home"/></a>
            </div>
        </div>
    </label>

    <input type="radio" name="tabs" id="tabfour">
    <label for="tabfour">
        <div class="dropdown">
            <button class="dropbtn"><spring:message code="studentPage.button.locale"/></button>
            <div class="dropdown-content">
                <a href="?lang=en_US"><spring:message code="studentPage.button.locale.en"/></a>
                <a href="?lang=ru_Ru"><spring:message code="studentPage.button.locale.ru"/></a>
            </div>
        </div>
    </label>
</div>
</body>








