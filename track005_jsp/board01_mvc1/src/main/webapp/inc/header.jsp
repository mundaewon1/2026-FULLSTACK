<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header>
	<div class="p-5 bg-primary text-white text-center">
	  <h1>THEJOA703</h1>
	  <p>MVC1 JSP PROJECT</p>
	</div>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Logo</a>
	  </div>
	  <div class="collapse navbar-collapse" id="mynavbar">
		<ul class="navbar-nav ms-auto">
		<!--  애플리케이션 루트기준 -->
		<%-- <%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> --%>
        <c:if test="${empty sessionScope.email}">
	        <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/LoginAction">Login</a>
	        </li>
	        
	        <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/JoinAction">Join</a>
	        </li>
	        
	        <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/Users">유저목록</a>
	        </li>
        </c:if>
        
        <c:if test="${not empty sessionScope.email}"> <!-- email 비어있지 않으면 표시 -->
	        <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/MyAction">Mypage</a>
	        </li>
	       
	        <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
	        </li>
	        
        </c:if>

       </ul>        
       </div>
	</nav>
</header>
    <!-- header.jsp -->
