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
<div class="container">
    <header></header>
    <header>Kategorie:<c:forEach items="${categories}" var="category"><a href="../category/${category.id}"> ${category.name} </a> ||</c:forEach> </header>
    <c:forEach items="${posts}" var="post">

        <div class="card">
            <div class="card-body">
                <h4> <a href="/../postpage/${post.id}">${post.title}</a> </h4> <br>
                    ${post.content  }
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>