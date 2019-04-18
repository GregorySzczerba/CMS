<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
<div class="container">
    <header></header>
    <header>Kategorie:<c:forEach items="${categories}" var="category"><a href="/../category/${category.id}">${category.name}</a>  ||</c:forEach> </header>

        <div class="card">
            <div class="card-body">
                <h4>${post.title}</h4>
                ${post.content}<br>
                <br><i>Data utworzenia ${post.created}</i>
            </div>
        </div>
        <h5>Komentarze do artykułu:</h5>
    <c:forEach items="${comments}" var="comment">
    <div class="card">
    <div class="card-body">
        Nick:<strong> ${comment.nick}</strong>
            <br>Treść komentarza: ${comment.content}
            <br><i>Skomentowano: ${comment.created}</i>
    </div>
</div>
    </c:forEach>

</div>
<form:form method="post" modelAttribute="comment">
    <div class="container">
        <header>Dodaj komentarz</header>
        <div class="card">
            <div class="card-body">
                <div class="form-group">
                    <label for="nickId">Nick :</label>
                    <form:input type="text" name="nick" path="nick" id="nickId" class="form-control"/>
                </div>
                <form:hidden value="${post.id}"  path="post.id"/>
                <div class="form-group">
                    <label for="contentId">Treść:</label>
                    <form:input type="text" path="content" name="content" id="contentId" class="form-control"/>
                </div>
                <input type="submit" value="Zapisz" class="btn btn-primary">
            </div>
        </div>

    </div>

</form:form>

</body>
</html>

