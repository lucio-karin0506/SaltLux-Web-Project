<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student insert</title>
</head>
<body>
<h1>학생 정보 입력</h1>
<c:url var="studentInsert" value="/admin/studentInsert"/>
<form action="${studentInsert}" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
   <th>번호</th>
   <td><input type="number" name="studentId" required></td>
</tr>
<tr>
   <th>이름</th>
   <td><input type="text" name="studentName" required></td>
</tr>
<tr>
   <th>이메일</th>
   <td><input type="text" name="emailId" required></td>
</tr>
<tr>
   <th>비밀번호</th>
   <td><input type="password" name="password" required></td>
</tr>
<tr>
   <th>사진</th>
   <td><input type="file" name="studentImage"></td>
</tr>
<tr>
   <td>
      <input type="submit" value="저장">
      <input type="reset" value="취소">
   </td>
</tr>
</table>
</form>
</body>
</html>