<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
<style>
   @import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
   * {
   font-family: 'Nanum Gothic', sans-serif;
   }
</style>
</head>
<body style="text-align:center;" width="100">
<h1>학생 정보 수정</h1> <br>
<c:url var="studentUpdate" value="/admin/studentUpdate"/>
<form action="${studentUpdate}" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
   <th>번호</th>
   <td><input type="number" name="studentId" value="${student.studentId}" ></td>
</tr>
<tr>
   <th>이름</th>
   <td><input type="text" name="studentName" value="${student.studentName}" required></td>
</tr>
<tr>
   <th>이메일</th>
   <td><input type="text" name="emailId" value="${student.emailId}" required></td>
</tr>
<tr>
   <th>비밀번호</th>
   <td><input type="password" name="password" value="${student.password}" required></td>
</tr>
<tr>
   <th>사진</th>
   <td><input type="file" name="studentImage" value="${student.studentImage}"></td>
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