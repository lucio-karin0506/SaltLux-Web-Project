<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제 파일 업로드</title>
</head>
<body>
<c:url var="actionURL" value='/excel/new'/>
<form action="${actionURL}" method="post" enctype="multipart/form-data">
<select name="subjectType">
		<option value="java">자바
		<option value="sql">sql
		<option value="springframework">스프링프레임워크
		<option value="python">파이썬
	</select>
	<input type="text" name="testName">
	<input type="file" name="file">
	<input type="submit" value=" 저장">
	<input type="reset" value=" 취소">
</form>	
</body>
</html>