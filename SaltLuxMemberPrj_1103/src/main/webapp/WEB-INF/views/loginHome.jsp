<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 시 페이지</title>
<style>
   @import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
   * {
   font-family: 'Gowun Dodum', sans-serif;
   }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body style="text-align:center;">
<div class="row text-center m-4">
   <div>
      <img src="./resources/image/saltlux.png" width ="100"> 
   </div>
<p><p>
<h1>'솔트룩스 채용확정형 빅데이터 AI 융합 개발자 양성과정' 학생 관리 애플리케이션</h1>
<p><p><p><p>
<c:choose>
	<c:when test="${id eq 'admin' && password eq '1234' }">
		<center>  
		<li>
           <p>관리자 ${id }님, 환영합니다.</p>
        </li>
		<div class="card-group" style="width:50%;">    
	          <div class="card" style="width:70%;">
	  				<div class="card-body">
	    			<h5 class="card-title" style="color:#0acf54;">모든 학생의 정보 조회</h5>
	    			<p class="card-text">학생들의 이름, 번호, 이메일 등 정보를 조회하려면 하단 링크를 클릭해주세요.</p>
	    			<a href='<c:url value="/admin/studentList"/>' class="btn btn-primary">GO</a>
	  			</div>
			  </div>
			  
			  <div class="card" style="width:70%;">
	  				<div class="card-body">
	    			<h5 class="card-title" style="color:#0097f6">학생 정보 입력</h5>
	    			<p class="card-text">학생 정보를 직접 입력하려면 하단 링크를 클릭해주세요.</p>
	    			<a href='<c:url value="/admin/studentInsert"/>'  class="btn btn-primary">GO</a>
	  			</div>
			  </div>
		</div>
	</center>
	</c:when>
	
	<c:otherwise>
		<center>  
		<li>
           <p>학생 ${id }님, 환영합니다.</p>
        </li>
			<div class="card-group" style="width:50%;">    
	          <div class="card" style="width:70%;">
	  				<div class="card-body">
	    			<h5 class="card-title" style="color:#0acf54;">시험 출제</h5>
	    			<p class="card-text">문제를 출제하려면 하단 링크를 클릭해주세요.</p>
	    			<a href='<c:url value="/student/test"/>' class="btn btn-primary">GO</a>
	  			</div>
			  </div>
	</center> 
	</c:otherwise>
</c:choose>
<a href='<c:url value="/logout"/>' class="btn btn-primary">로그아웃</a>
</body>
</html>
