<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file = "./inc/header.jsp"%>

   <div class="container card my-5">
      <h3 class="card-header">글 수정</h3>

       <form action="#" method="post" onsubmit="return ck()">
       <div class="my-3">
	       <label for="bname" class="form-label">이름</label>
	       <Input type="text" class="form-control" id="bname" name="bname" readonly/>
       </div>
       <div class="my-3">
	       <label for="bpass" class="form-label">비밀번호</label>
	       <Input type="text" class="form-control" id="bpass" name="bpass"/>
       </div>
       <div class="my-3">
	       <label for="btitle" class="form-label">제목</label>
	       <Input type="text" class="form-control" id="btitle" name="btitle"/>
       </div>
       <div class="my-3">
	       <label for="bcontent" class="form-label">내용</label>
	       <textarea type="text" class="form-control" id="bcontent" name="bcontent"></textarea>
	   </div>
       <div class="my-3 text-end">
           <button type="submit"   class="btn btn-outline-primary"  title="글취소">취소</button>
           <a href="detail.jsp"             class="btn btn-outline-success"  title="목록보러가기">목록</a>
           <button type="reset"  class="btn btn-primary"  title="글등록">글쓰기</button>
       </div>
       </form>
       
       <script>
       function ck(){
   	    	let bname = document.getElementById("bname");	
   	    	let bpass = document.getElementById("bpass");	
   	    	let btitle = document.getElementById("btitle");	
   	    	let bcontent = document.getElementById("bcontent");
   	    	
   	    	if(bname.value.trim() == ""){ alert("이름을 입력해주세요."); bname.focus(); return false; }
   	    	if(bpass.value.trim() == ""){ alert("비밀번호 입력해주세요."); bpass.focus(); return false; }
   	    	if(btitle.value.trim() == ""){ alert("제목을 입력해주세요."); btitle.focus(); return false; }
   	    	if(bcontent.value.trim() == ""){ alert("내용을 입력해주세요."); bcontent.focus(); return false; }
   	    	else {alert("글쓰기 성공");}
   	    return true;
       };
       </script>
       
   </div>
   
<%@ include file = "./inc/footer.jsp"%>