<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>JSP 첫 실습</title>

    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>게시판</h1>

<sec:authorize access = "isAnonymous()">
    <button onclick = "location.href= '/login'">로그인</button>
</sec:authorize>


<sec:authorize access = "isAuthenticated()">
    <sec:authentication property="principal.username" /> 님 안녕하세요.
    <form method = "POST" action = "/logout">
        <input type = "submit" value = "로그아웃"/>
    </form>
</sec:authorize>

<form method = "GET" action = "/">
    <select name = "type">
        <option value = "title">제목으로 검색</option>
        <option value = "author">작성자로 검색</option>
        <option value = "content">내용으로 검색</option>
    </select>
    <input type = "text" name = "keyword">
    <input type = "submit" value = "검색">
</form>


<c:forEach var = "article" items = "${articles}">
    <a href="/view?id=${article.id}">
        <div class = "div_article">
            <c:out value="${article.title}"/>
        </div>
    </a>
</c:forEach>
</body>
</html> 