<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<c:url value="/webjars/jquery/3.1.1/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
<link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<html>
<head>
    <%@include file="../header.jspf" %>
    <script>
        function confirmDelete(id, title) {
            if (confirm("Czy chcesz usunąć user \"" + title + "\"?")) {
                window.location.href = "/admin/user/" + id;
            }
        }
    </script>

</head>
<body>
<div class="container">



    <div class="card">
        <div class="card-body">
            <a href="/users/add" class="btn btn-primary">Add user</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>email</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="../admin/update/${user.id}" class="btn btn-warning">Edytuj</a>
                            <a href="#" onclick="confirmDelete(${user.id}, '${user.lastName}')" class="btn btn-danger">Skasuj</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <a href="/admin/login">Moderacja |</a> <a href="/admin/adminaccount">Admin panel |</a> <a href="/admin/logout">Admin logout</a>

</div>

</body>
</html>

