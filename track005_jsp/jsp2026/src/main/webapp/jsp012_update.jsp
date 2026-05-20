<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	//1. utf-8 설정
	request.setCharacterEncoding("utf-8");

	int ono 		= Integer.parseInt(request.getParameter("ono"));
	String oname 	= request.getParameter("oname");
	int onum 		= Integer.parseInt(request.getParameter("onum"));
	out.println(ono + oname + onum);
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "update milk_order set oname=?, onum=? where ono=?"; //##
		conn = DriverManager.getConnection( url,"root","1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString( 1	, oname);
		pstmt.setInt(	 2	, onum);
		pstmt.setInt( 	 3	, ono);

		int result = pstmt.executeUpdate();  // insert, update, delete 실행한 줄 수
		//4. jsp012_milks.jsp 로 돌아가기		- 알림창		주소표시창줄
		if(result > 0 ){ 
			out.println("<script> alert('수정성공');  location.href='jsp012_milks.jsp';    </script>");
		}else{
			out.println("<script> alert('수정실패');  location.href='jsp012_milks.jsp';    </script>");
		}
		
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		}catch(Exception a ){ a.printStackTrace(); } 
%>