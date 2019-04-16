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
<body>

<form method="post" action="login">

    <div class="container">

        <header>Login</header>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="usernameId">Email :</label>
                    <input type="text" name="email" id="usernameId" class="form-control">
                    <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Hasło:</label>
                    <input type="password" name="password" id="passwordId" class="form-control">
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <c:if test="${isLogged == false}">
                    <div class="error">Login failed</div><br><br>
                </c:if>

                <input type="submit" value="Login" class="btn btn-primary">
                <a href="/register" class="btn btn-primary">Rejestracja</a>

            </div>
        </div>

    </div>

</form>
</body>
</html>