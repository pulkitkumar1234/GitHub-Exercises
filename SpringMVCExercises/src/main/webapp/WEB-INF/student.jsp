<%--
  Created by IntelliJ IDEA.
  User: arpit
  Date: 18/3/19
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>

<!--QUESTION 5-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${Hello}
<form:errors path="student.*"/>
<form action="submitStudent" method="get">
    First name:<input type="text" name="firstName">
    <br>
    Last name:<input type="text" name="lastName">
    <br>
    Passowrd:<input type="text" name="password">
    <br>
    <input type="submit">
</form>
</body>
</html>
