<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Speciality adding</title>
</head>
<body>
<form:form modelAttribute="speciality"  method="post">
    <table>
        <tr>
            <td>
                <form:label path="name">Name</form:label>
            </td>
            <td>
                <form:input path="name" name="name" id="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:button id="submit" name="submit">Submit</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
