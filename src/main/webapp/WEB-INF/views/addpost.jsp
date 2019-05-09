<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
    <title>Dodaj post </title>
</head>
<body>
<%@include file="header.jspf" %>
<form:form method="post" modelAttribute="post">
    <div class="container">
        <header>Dodaj post</header>
        <div class="card-body">
            <div class="form-group col-md-12">
                <label for="titleId">Tytuł:</label>
                <form:input type="text" path="title" class="form-control" id="titleId"/>
            </div>

            <div class="form-group col-md-12">
                <label for="contentId">Treść:</label>
                <form:textarea rows="16" cols="90" path="content" class="form-control" id="contentId"/>
            </div>
            <form:hidden value="${user.id}" path="user.id"/>
        </div>
        <div class="form-group col-md-12">
            <label for="categoryId">Kategoria:</label>
            <form:select itemValue="id" itemLabel="name" path="category.id" items="${categories}"
                         class="form-control" id="categoryId"/>
        </div>
        <form method="POST" action="upload" enctype="multipart/form-data">
            File to upload: <input type="file" name="file"><br />
            Name: <input type="text" name="text"><br /> <br />
            <input type="submit" value="Upload"> Press here to upload the file!
        </form>
        <input type="submit" value="Zapisz" class="btn btn-primary">
    </div>
    </div>
    </div>
</form:form>
</body>
</html>