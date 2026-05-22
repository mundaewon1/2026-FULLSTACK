<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file = "./inc/header.jsp" %>
    <!-- content -->
    <section class="container my-5">
        <h3> Q N A 상세보기 </h3>
        <p class="my-4"></p>
        <hr/>

		<div>
		  <section class="container my-5">
        <h3> MultiBoard </h3>
        <table class="table  table-striped  table-bordered table-hover">
            <caption> BOARD 목록 </caption>
            <thead>
            <tr>
                <th scope="col">BNO</th>
                <th scope="col">TITLE</th>
                <th scope="col">WRITER</th>
                <th scope="col">DATE</th>
                <th scope="col">HIT</th>
            </tr>
            </thead>
            <tbody>
          <%
	       try{
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       PreparedStatement pstmt = null; Connection conn = null; ResultSet rset = null;
	       String url = "jdbc:mysql://localhost:3306/mbasic";
	       String sql = "select * from mvcboard1 order by bno desc";
	       conn = DriverManager.getConnection(url,"root","1234");
	       pstmt = conn.prepareStatement(sql);
	       
	       rset = pstmt.executeQuery();
		   
	       while ( rset.next() ){
	    	   out.println("<tr><td>"+rset.getInt("bno")+
	    			   "</td><td><a href='detail.jsp?bno="+rset.getInt("bno")+"'>"
	    	   			+rset.getString("btitle")+
	    			   "</a></td><td>"+rset.getString("bname")+
	    			   "</td><td>"+rset.getString("bdate")+
	    			   "</td><td>"+rset.getInt("bhit")+"</td></tr>");
	       }
	       if(rset != null){ rset.close();}
	       if(pstmt != null){ pstmt.close();}
	       if(conn != null){ conn.close();}
	       }catch(Exception a){ a.printStackTrace();}
       	   %>
            </tbody>
        </table>

        <div class="text-end">
            <a href="write.jsp"  title="글쓰기 폼" class="btn btn-primary">글쓰기</a>
        </div>
    	  </section>				
       
       
		</div>
    </section>
 
<%@ include file = "./inc/footer.jsp" %>