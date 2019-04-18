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

    <header>Moje konto: Witaj ${user.firstName} ${user.lastName} ||<a href="update/${user.id}"> Edytuj Twoje dane</a> </header>
    <header>    Twoje zaakceptowane posty:<br>
        <c:forEach items="${postList}" var="post"><a href="postpage/${post.id}">${post.title}</a></header>
            <div class="card">
                    ${post.content.substring(0, 160)}
                <div class="card-body">
                    <br>
                </div>
            </div>
        </c:forEach>

    </div>
</body>
</html>

