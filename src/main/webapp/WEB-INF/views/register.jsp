<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
&lt;%&ndash;<%@include file="header.jspf" %>&ndash;%&gt;
comments
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
</html>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<c:url value="/webjars/jquery/3.1.1/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
<link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<html>
<head>
    <%@include file="header.jspf"%>
</head>
<form:form method="post" modelAttribute="user">

    <div class="container">

        <header>Zarejestruj się </header>

        <div class="card mt-4">

            <div class="card-header">
                Podaj dane
            </div>

            <div class="card-body">

                <div class="row">
                </div>

                <div class="form-group">
                </div>
                <div class="form-group">
                    <label for="firstId">Imię :</label>
                    <form:input type="text" path="firstName" items="" itemLabel="firstName"
                                 class="form-control" id="firstId"/>
                    <form:errors path="firstName" element="div" cssClass="error"/>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="lastId">Nazwisko :</label>
                        <form:input type="tet" path="lastName" class="form-control" id="lastId"/>
                        <form:errors path="lastName" element="div" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="email">Email :</label>
                        <form:input type="email" path="email" class="form-control" id="email"/>
                        <form:errors path="email" element="div" cssClass="error"/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="email">Hasło :</label>
                        <form:password  path="password" class="form-control" id="email"/>
                        <form:errors path="password" element="div" cssClass="error"/>
                    </div>
                </div>

                <input type="submit" type="button" value="Zarejestruj się" class="btn btn-primary btn-lg">

            </div>


        </div>

    </div>

</form:form>

</body>
</html>
