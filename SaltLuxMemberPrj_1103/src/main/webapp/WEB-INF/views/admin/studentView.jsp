<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회</title>
<style>
   @import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
   * {
   font-family: 'Nanum Gothic', sans-serif;
   }
   table.table > thead > tr > th{
    border-bottom: 1px solid black;
  }
</style>
</head>
<body style="text-align:center;" width="100">
<h1>학생 정보 상세 조회</h1> <br>
	<div style="width: 70%; float:none; margin:0 auto">
		<div class="row text-center m-4">
			<table class="table table-hover" border="1">
					<tr class="table-light">
						<th>학생 번호</th>
						<th>학생 이름</th>
						<th>이메일</th>
						<th>비밀번호</th>
						<th>사진</th>
					</tr>	
					<tr>	
						<td>${student.studentId}</td>
						<td>${student.studentName}</td>
						<td>${student.emailId}</td>
						<td>${student.password}</td>
						<td>${student.studentImage}</td>
					</tr>
			</table>
		</div>
	</div>
<a href="studentUpdate?studentId=${student.studentId}">수정하기</a>
<a href="studentDelete?studentId=${student.studentId}">삭제하기</a>
</body>
</html>