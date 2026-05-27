<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
	session.invalidate();  // 세션지우기
	out.println("<script>alert('로그아웃 성공'); location.href='jsp016_login.jsp'; </script>");
%>