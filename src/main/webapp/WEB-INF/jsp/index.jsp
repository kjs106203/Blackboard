<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 첫 실습</title>

    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>게시판</h1>
<c:forEach var = "article" items = "${articles}">
    <a href="/view?id=${article.id}">
        <div class = "div_article">
            <c:out value="${article.title}"/>
        </div>
    </a>
</c:forEach>
</body>
</html>