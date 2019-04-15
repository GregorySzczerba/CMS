<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/main.css" rel="stylesheet">

<html>
<head>
    <%@include file="header.jspf"%>

</head>
<body>
<div class="container">
    <header>Użytkownicy</header>
    <div class="card">
        <div class="card-body">
            <a href="/user/add" class="btn btn-primary" >Dodaj użytkownika</a>
        </div>
        <table class="table table-hover">
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Email</th>

            <th>Akcja</th>
            <c:forEach items="" var="user">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</div>

</body>
</html>

