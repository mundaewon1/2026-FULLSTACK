<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file = "./inc/header.jsp"%>


   <div class="container card my-5">
      <h3 class="card-header">글 삭제</h3>

       <form action="delete_action.jsp?bno=<%=request.getParameter("bno") %>" method="post" onsubmit="return ck()">
       <div class="my-3">
	       <label for="bpass" class="form-label">비밀번호 입력</label>
	       <Input type="text" class="form-control" id="bpass" name="bpass"/>
       </div>
       <div class="my-3">
           <button type="reset"   class="btn btn-outline-primary"  title="취소">취소</button>
           <a href="list.jsp"  class="btn btn-primary"  title="목록">목록</a>
           <button type="submit"   class="btn btn-outline-primary"  title="확인">확인</button>
       </div>
       </form>
       
       <script>
       function ck(){	
   	    	let bpass = document.getElementById("bpass");	
   	    	
   	    	if(bpass.value.trim() == ""){ alert("비밀번호 입력해주세요."); bpass.focus(); return false; }
   	    return true;
       };
       </script>
   </div>
   
<%@ include file = "./inc/footer.jsp"%>