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
            if (confirm("Czy chcesz usunąć post \"" + title + "\"?")) {
                window.location.href = "/admin/delete/" + id;
            }
        }
    </script>

</head>
<body>
<div class="container">



    <div class="card">
        <div class="card-body">
            <a href="/posts/add" class="btn btn-primary">Add post</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Tytuł</th>
                    <th>User ID</th>
                    <th>Data</th>
                    <th style="width: 15%">Actions</th>
                </tr>
                <c:forEach items="${postList}" var="post">
                    <tr>
                        <td><a href="/postpage/${post.id}">${post.title}</a></td>
                        <td>${post.user.id}</td>
                        <td>${post.created}</td>
                        <td>
                            <a href="accept/${post.id}" class="btn btn-success">Akceptuj</a>
                            <a href="../post/update/${post.id}" class="btn btn-warning">Edytuj</a>
                            <a href="#" onclick="confirmDelete(${post.id}, '${post.title}')" class="btn btn-danger">Skasuj</a>
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

