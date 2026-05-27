<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
//1. 데이터 넘겨받기
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
//2. sql 구문처리 select * from users where email=? and bpass=?
	Connection conn = null; PreparedStatement pstmt = null;	ResultSet rset = null;
	String user = "root";	String pass = "1234";
	String url = "select * from users where email=? and bpass=?";
	String sql = "jdbc:mysql://localhost:3306/mbasic";
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,user,pass);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,email);
	pstmt.setString(2,bpass);
	
	rset = pstmt.executeQuery();
	//3. 로그인성공시 - session 설정 (session.setAttribute) / jsp016_login.jsp 페이지로 넘어가기
	if(pstmt.executeUpdate() >0){
		session.setAttribute("email", email);
		out.println("<script>alert('로그인 성공'); location.href='jsp016_login.jsp'; </script>");
	}else{
		out.println("<script>alert('로그인 실패'); history.go(-1); </script>");
	}
	
	if(pstmt != null){pstmt.close();}
	if(conn != null){conn.close();}
	}catch(Exception a){ a.printStackTrace();}


%>