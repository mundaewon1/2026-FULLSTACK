<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("utf-8");

	String oname = request.getParameter("oname");
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null; PreparedStatement pstmt = null;
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String sql = "delete from milk_order where name=?";
	conn = DriverManager.getConnection(url,"root","1234");
	pstmt = conn.prepareStatement(sql);
	
	
	if (conn != null){}
	}catch(Exception a){ a.printStackTrace();}
%>