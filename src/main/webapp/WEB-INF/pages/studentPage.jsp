<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <title>Student Page</title>
    <link rel="stylesheet" href="/resources/css/studentPage.css">
    <link rel="stylesheet" href="/resources/css/table.css">
</head>
<div class="tabs">
    <input type="radio" name="tabs" id="tabone" checked="checked">
    <label for="tabone">Student Page</label>
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
    <label for="tabtwo">Exams</label>
    <div class="tab">
        <table id="list">
            <c:choose>
                <c:when test="${empty examList}">
                    <tr><spring:message code="studentPage.message.haveNoExams"/></tr>
                    <tr><a href="specialityList"><spring:message code="studentPage.button.apply"/></a></tr>
                </c:when>
                <c:otherwise>
                    <tr>${message}</tr>
                    <tr>
                        <th><spring:message code="studentPage.lable.speciality"/></th>
                        <th><spring:message code="studentPage.lable.subject"/></th>
                        <th><spring:message code="studentPage.lable.teacher"/></th>
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
    </div>

    <input type="radio" name="tabs" id="tabthree">
    <label for="tabthree">
        <div class="dropdown">
            <button class="dropbtn">Navigation</button>
            <div class="dropdown-content">
                <a href="/logout">Logout</a>
                <a href="/">Home</a>
            </div>
        </div></label>

<input type="radio" name="tabs" id="tabfour">
<label for="tabfour">
    <div class="dropdown">
        <button class="dropbtn">Locale</button>
        <div class="dropdown-content">
            <a href="?lang=en_US">EN</a>
            <a href="?lang=ru_Ru">RUS</a>
        </div>
    </div></label>
</div>








