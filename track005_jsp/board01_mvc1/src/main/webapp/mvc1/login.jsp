<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="mt-4 p-5 bg-primary text-white text-center">
	  <h1>THEJOA703</h1>
	  <p>MVC1 JSP PROJECT</p>
	</div>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Logo</a>
	  </div>
	  <div class="collapse navbar-collapse" id="mynavbar">
		<ul class="navbar-nav ms-auto">
        <li class="nav-item">
        <a class="nav-link" href="javascript:void(0)">Login</a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="javascript:void(0)">Join</a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="javascript:void(0)">Mypage</a>
        </ul>
       </div>
	</nav>
	
	<div class="container my-4">
		<h2>로그인</h2>
			<form action="login_action.jsp" method="get" onsubmit="return ck()">
				<div class="my-3">
				<label for="email" class="form-label">이메일</label>
				<input type="text" class="form-control" id="email" name="email"/>
				</div>
				<div class="my-3">
				<label for="bpass" class="form-label">비밀번호</label>
				<input type="text" class="form-control" id="bpass" name="bpass"/>
				</div>
			
			<div class="text-end">
				<button type="reset" class="btn btn-outline-info">취소</button>
				<button type="submit" class="btn btn-info">로그인</button>
			</div>
			</form>
				
		<script>
		function ck(){
			let bpass = document.getElementById("bpass");
			let email = document.getElementById("email");

			if(bpass.value.trim()==""){ alert("비밀번호를 확인해주세요"); bpass.focus(); return false; }
			if(email.value.trim()==""){ alert("이메일을 확인해주세요"); email.focus(); return false; }
			return true;
		};
		</script>
			
	</div>
	
<%@ include file = "./inc/footer.jsp" %>