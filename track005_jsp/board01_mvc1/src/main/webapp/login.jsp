<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file = "inc/header.jsp" %>

	<div class="container my-4">
		<h2>로그인</h2>
			<form action="LoginAction" method="post" onsubmit="return ck()">
				<div class="my-3">
				<label for="email" class="form-label" >이메일</label>
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

<%@ include file = "inc/footer.jsp" %>