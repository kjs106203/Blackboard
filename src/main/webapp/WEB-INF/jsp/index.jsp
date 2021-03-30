<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>JSP 첫 실습</title>

    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/index.css">

    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"></script>

    <script src="js/common.js"></script>
    <script src="js/askLogout.js"></script>
</head>
<div>
<h1>게시판</h1>

<sec:authorize access = "isAnonymous()">
    <button id="btn_login" onclick = "location.href= '/login'">로그인</button>
</sec:authorize>


<sec:authorize access = "isAuthenticated()">
    <sec:authentication property="principal.username" /> 님 안녕하세요.
    <spring:form method = "POST" action = "/logout" onsubmit="return confirm('로그아웃 하시겠습니까?')">
        <input type = "submit" value = "로그아웃"/>
    </spring:form>
</sec:authorize>

<div id="divSearchTop">
    <form method = "GET" action = "/">
        <select name = "type">
            <option value = "title">제목으로 검색</option>
            <option value = "author">작성자로 검색</option>
            <option value = "content">내용으로 검색</option>
        </select>
        <input type = "text" name = "keyword">
        <input type = "submit" value = "검색">
    </form>
</div>


<c:forEach var = "article" items = "${articles}">
    <div class = "div_article" id = "div_article${article.id}">
        <c:out value="${article.title}"/>
        <div id = "divContent${article.id}"></div>
    </div>
</c:forEach>

<script>
    function loadContent(id) {
        $.get("/view?id=" + id, function(serverresponse) {
            $("#divContent" + id).html(serverresponse)
        }, 'html');
    }

    <c:forEach var = "article" items ="${articles}">
    $("#div_article${article.id}").on("click", function() {
        loadContent(${article.id});
    })
    </c:forEach>


</script>

<div id="divSearchBottomFrame">
<div id="divSearchBottom">
    <form method = "GET" action = "/">
        <select name = "type">
            <option value = "title">제목으로 검색</option>
            <option value = "author">작성자로 검색</option>
            <option value = "content">내용으로 검색</option>
        </select>
        <input type = "text" name = "keyword">
        <input type = "submit" value = "검색">
    </form>
</div>
</div>
</div>
</body>
</html> 