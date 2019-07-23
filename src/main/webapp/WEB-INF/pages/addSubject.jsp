<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject adding</title>
</head>
<body>
<form:form modelAttribute="subject"  method="post">
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