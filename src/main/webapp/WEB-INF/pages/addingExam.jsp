<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Adding Exam</title>
    <link rel="stylesheet" href="/resources/css/select.css"/>
</head>
<body>
<form:form method="post" commandName="exam">
<table>
    <tr>
        <td>
            <label>Speciality</label>
        </td>
        <td>
            <form:select path="speciality">
                <form:options items="${specialityList}" itemValue="id" itemLabel="name"/>
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            <label>Subject</label>
        </td>
        <td>
            <form:select path="subject">
                <form:options items="${subjectList}" itemValue="id" itemLabel="name"/>
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            <label>Teacher</label>
        </td>
        <td>
            <form:select path="teacher">
               <form:options items="${teacherList}" itemValue="id" itemLabel="lastName"/>
            </form:select>
        </td>
    </tr>

    <button>Confirm</button>
</table>
</form:form>
</body>
</html>
