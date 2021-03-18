<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
    <spring:form method = "POST" action = "/login">
        <input type = "text" name = "username"/>
        <input type = "password" name = "password"/>
        <input type = "submit" value = "로그인"/>
    </spring:form>
</body>
</html>