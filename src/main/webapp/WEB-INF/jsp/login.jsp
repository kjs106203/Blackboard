<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>

    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <script src="js/saveId.js"></script>
</head>
<body>
    <spring:form method = "POST" action = "/login" onsubmit="saveId()">
        <input type = "text" name = "username" id="inputId"/>
        <input type = "password" name = "password"/>
        <input type="checkbox" id="chkSaveId">
        <label for="chkSaveId">아이디 저장</label>
        <input type = "submit" value = "로그인"/>
    </spring:form>
</body>
</html>