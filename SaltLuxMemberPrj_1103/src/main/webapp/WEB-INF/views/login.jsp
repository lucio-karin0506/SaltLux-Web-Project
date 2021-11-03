<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>

<h1>login</h1>

<c:url var="loginURL" value="/login"/>

<form action="${loginURL }" method="post">
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="password">
		<input type="submit" value=" 로그인 ">
</form>

</body>
</html>