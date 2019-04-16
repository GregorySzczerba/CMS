<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
    <title>Dodaj post</title>
</head>
<body>

<%@include file="header.jspf" %>

<form:form method="post" modelAttribute="post" enctype="multipart/form-data" >

    <div class="container">

        <header>Dodaj post</header>

        <div class="card">
            <div class="card-body">
                <a href="/" class="btn btn-primary">Wróć</a>
            </div>
        </div>


            <div class="card-header">
                Book data
            </div>

            <div class="card-body">

                    <div class="form-group col-md-4">
                        <label for="titleId">Tytuł:</label>
                        <form:input type="text" path="title" class="form-control" id="titleId"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="contentId">Treść:</label>
                        <form:textarea rows="6" cols="90" path="content" class="form-control" id="contentId"/>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="imagesId">Dodaj zdjęcie:</label>
                        <form:input type="file" path="image" name ="${image.originalFilename}" class="form-control" id="imagesId"/>
                    </div>

                </div>
                <div class="form-group">
                    <label for="categoryId">Kategoria:</label>
                    <form:select itemValue="id" itemLabel="name" path="category.id" items="${categories}"
                                 class="form-control" id="categoryId"/>
                </div>

                <input type="submit" value="Zapisz">

            </div>


        </div>

    </div>

</form:form>

</body>
</html>