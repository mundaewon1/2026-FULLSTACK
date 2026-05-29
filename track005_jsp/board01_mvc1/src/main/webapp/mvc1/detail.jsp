<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file = "./inc/header.jsp"%>

<%
//1. bno 넘겨받기
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
//2. sql 구문 2개 처리
String bname = "", btitle="", bcontent=""; int bhit=0;

try{ 
	 Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	 
	 String sql1="update mvcboard1 set bhit=bhit+1 where bno=? ";
	 String sql2="select * from mvcboard1 where bno=? ";
	 
	 String url="jdbc:mysql://localhost:3306/mbasic";
	 
	 Class.forName("com.mysql.cj.jdbc.Driver");		//1. 드라이버로딩
	 conn = DriverManager.getConnection(url,"root","1234");		//2. jdbc연동
	 //3. sql 구문처리 
	 pstmt = conn.prepareStatement(sql1);	pstmt.setInt(1, bno);  //얘는 조회수 숫자 증가용
	 if( pstmt.executeUpdate() > 0) { pstmt.close(); }

	 pstmt = conn.prepareStatement(sql2);	pstmt.setInt(1, bno);
	 rset = pstmt.executeQuery(); //표
	 if(rset.next()){ //줄 데이터 변수에 긁어오기용
		 bname = rset.getString("bname");		btitle = rset.getString("btitle");
		 bcontent = rset.getString("bcontent");		bhit = rset.getInt("bhit");
	 }
	 
     if(rset != null){ rset.close();}
     if(pstmt != null){ pstmt.close();}
     if(conn != null){ conn.close();}
}catch(Exception a ){ a.printStackTrace();}
%>
   <div class="container card my-5">
      <h3 class="card-header">Q N A 상세보기</h3>

       <form action="#" method="post" onsubmit="return ck()">
       
       <div class="my-3">
       <p class="my-3 mx-3">  + 조회수</p>
       
       <p class="my-3 mx-3">  <%=bhit%></p>
       
       <hr/>
       </div>
       <div class="my-3">
	       <label for="bname" class="form-label">이름</label>
	       <input type="text" class="form-control" value="<%=bname%>" id="bname" name="bname" readonly/>
       </div>
       <div class="my-3">
	       <label for="btitle" class="form-label">제목</label>
	       <input type="text" class="form-control" value="<%=btitle%>"id="btitle" name="btitle" readonly/>
       </div>
       <div class="my-3">
	       <label for="bcontent" class="form-label">내용</label>
	       <textarea type="text" class="form-control" 
	       id="bcontent" name="bcontent" readonly><%=bcontent%></textarea>
	   </div>
       <div class="my-3 text-end">
           <a href="edit.jsp?bno=<%=bno%>"  class="btn btn-outline-primary"  title="글수정">수정</a>
           <a href="delete.jsp?bno=<%=bno%>"  class="btn btn-outline-success"  title="글삭제">삭제</a>
           <a href="list.jsp"  class="btn btn-primary" 			title="목록보러가기">목록</a>
       </div>
       </form>
       
       <script>
       function ck(){
   	    	let bname = document.getElementById("bname");	
   	    	let btitle = document.getElementById("btitle");	
   	    	let bcontent = document.getElementById("bcontent");
   	    	
   	    	if(bname.value.trim() == ""){ alert("이름을 입력해주세요."); bname.focus(); return false; }
   	    	if(btitle.value.trim() == ""){ alert("제목을 입력해주세요."); btitle.focus(); return false; }
   	    	if(bcontent.value.trim() == ""){ alert("내용을 입력해주세요."); bcontent.focus(); return false; }
   	    return true;
       };
       </script>
       
   </div>

<%@ include file = "./inc/footer.jsp"%>