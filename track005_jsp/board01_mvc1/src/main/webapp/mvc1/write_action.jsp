<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
	request.setCharacterEncoding("utf-8");
	String bname = request.getParameter("bname");
	String bpass = request.getParameter("bpass");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	String bip = request.getParameter("bip");
	
    
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    PreparedStatement pstmt = null; Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/mbasic";
    String sql = "insert into mvcboard1 (bname, bpass, btitle, bcontent, bip) values (?,?,?,?,?)";
    conn = DriverManager.getConnection(url,"root","1234");
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, bname);
    pstmt.setString(2, bpass); 
    pstmt.setString(3, btitle);
    pstmt.setString(4, bcontent);
    pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
    
    if(pstmt.executeUpdate() > 0) {
    	out.println("<script> alert('글쓰기 성공'); location.href='list.jsp'; </script>");
    }else{ out.println("<script> alert('글쓰기 실패'); location.href='list.jsp'; </script>"); }
    
    if(pstmt != null){ pstmt.close();}
    if(conn != null){ conn.close();}
    }catch(Exception a){ a.printStackTrace();}
    
%>