<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/main.css" rel="stylesheet">
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<%--<%@include file="header.jspf" %>--%>

<form:form method="post" modelAttribute="user">

    <label>Imię:
        <form:input type="text" path="firstName"/>
    </label>
    <label>Nazwisko:
        <form:input type="text" path="lastName"/>
    </label>
    <br><br>

    <label>Hasło:
        <form:password path="password"/>
    </label>

    <br><br>

    <label>Email:
        <form:input type="email" path="email"/>
    </label>

    <br><br>

    <input type="submit" value="Zarejestruj"/>

</form:form>

</body>
</html>
