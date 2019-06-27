<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Exam</title>
</head>
<body>
<form>
<table>
    <tr>
        <td>
            <label>Speciality</label>
        </td>
        <td>
            <select name="speciality">
                <c:forEach items="${specialityList}" var="speciality">
                    <option value="${speciality.name}">${speciality.name}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <label>Subject</label>
        </td>
        <td>
            <select name="subject">
                <c:forEach items="${subjectList}" var="subject">
                    <option value="${subject.name}">${subject.name}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>
            <label>Teacher</label>
        </td>
        <td>
            <select name="teacher">
                <c:forEach items="${teacherList}" var="teacher">
                    <option value="${teacher.lastName}">${teacher.lastName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
</table>
</form>
</body>
</html>
