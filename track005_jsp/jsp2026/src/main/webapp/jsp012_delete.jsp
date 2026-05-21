<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("utf-8");

	int ono = Integer.parseInt(request.getParameter("ono"));
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String sql = "delete from milk_order where ono = ? ";
	conn = DriverManager.getConnection(url,"root","1234");
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt( 1, ono);
	
	//int result = pstmt.executeUpdate();
	//4. jsp012_milks.jsp 로 돌아가기		- 알림창		주소표시창줄
	if(pstmt.executeUpdate() > 0 ){ 
		out.println("<script> alert('주문삭제 완료');  location.href='jsp012_milks.jsp';    </script>");
	}else{
		out.println("<script> alert('관리자에게 문의해주세요');  location.href='jsp012_milks.jsp';    </script>");
	}
	
	if(pstmt != null){pstmt.close();}
	if(conn != null){conn.close();}
	}catch(Exception a ){ a.printStackTrace();}
	
%>