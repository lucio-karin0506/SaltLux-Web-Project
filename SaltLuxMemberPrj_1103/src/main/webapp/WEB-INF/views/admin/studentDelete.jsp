<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 삭제</title>
</head>
<body>
<h1>학생 정보 삭제</h1>
${student.studentId}학생 ${student.studentName} 의 정보를 삭제합니다.<p>
삭제후 데이터는 복구될 수 없습니다.<p>
${student.studentId}학생의 이메일을 입력하세요.
<form action="./delete" method="post">
이메일 : <input type="text" name="emailId">
<input type="hidden" name="studentId" value="${student.studentId}">
<input type="submit" value="삭제">
</form>
</body>
</html>