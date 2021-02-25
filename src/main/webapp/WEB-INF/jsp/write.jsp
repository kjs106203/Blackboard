<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>내용</title>
</head>
<body>
    <form:form commandName = "article" method = "POST">
        <label>제목</label>
        <input type = "text" name = "title" />
        <label>내용</label>
        <input type = "text" name = "content"/>
        <input type = "hidden" name = "author" value = "<sec:authentication property = "principal.username"/>">
        <input type = "hidden" name = "password" value = "<sec:authentication property = "principal.password"/>">
        <input type = "submit" value = "작성" />
    </form:form>
</body>
</html>