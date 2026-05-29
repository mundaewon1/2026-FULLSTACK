<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("utf-8");
	int uno = Integer.parseInt(request.getParameter("uno"));
	String nickname = request.getParameter("nickname");
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	String udate = request.getParameter("udate");
	String bip = request.getParameter("bip");
	
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	String user = "root"; String pass = "1234";
	String url = "jdbc:mysql://localhost:3306/mbasic";
	
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,pass);
		
	}catch(Exception a){ a.printStackTrace();}
%>