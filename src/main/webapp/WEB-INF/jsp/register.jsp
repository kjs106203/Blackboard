<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <form:form commandName = "user" method = "POST">
        <label>ID</label>
        <input type="text" name = "username"/>
        <label>비밀번호</label>
        <input type="password" name = "password"/>
        <label>이름</label>
        <input type="text" name = "name"/>
        <label>전화번호</label>
        <input type="text" name = "phone"/>
        <label>나이</label>
        <input type="number" name = "age"/>
        <input type="submit" name = "작성"/>
    </form:form>
</body>
</html>