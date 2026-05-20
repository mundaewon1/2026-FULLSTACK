<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!--		 header		 -->
<!--		 header		 bootstrap 5 -> jumbotron -->
<div class="p-5 bg-primary text-white rounded">
  <h1>Milk Order Project</h1>
  <p>MVC1 = PreparedStatement Ex</p>
</div>

<!--		 메뉴판테이블		 -->
<!--		 메뉴판테이블		 -->
	<div class="container card my-5 bg-primary text-white">
		<h2 class="card-header">Milk Menu</h2>
		
		<table class="table table-white table-striped table-hover">
		    <caption>우유메뉴</caption>
		    <thead>
		      <tr>
		        <th scope="col">NO</th>
		        <th scope="col">NAME</th>
		        <th scope="col">PRICE</th>
		      </tr>
		    </thead>
		    <tbody>
		    <%
		    try{
		    	//1. 드라이버연동
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    	//2. jdbc 연동
		    	Connection conn = DriverManager.getConnection(
		    			"jdbc:mysql://localhost:3306/mbasic", "root", "1234");
		/*     	PreparedStatement pstmt1 = conn.prepareStatement("insert into milk(mno,mname,mprice) values(?,?,?)");
		    	pstmt1.setInt(1,3);
		    	pstmt1.setString(2,"banana");
		    	pstmt1.setInt(3,1800);
		    	
		      	int result = pstmt1.executeUpdate();
		      	if(result>0){out.println("insert 성공");} */
		    	/*	1	white	1500
		    		2	choco	1800
		    		3	banana	1800   	*/
		    	//3. PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기
 		    	PreparedStatement pstmt = null; ResultSet rset = null;
		    	pstmt = conn.prepareStatement("select * from milk order by mprice asc");
		    	
		    	rset = pstmt.executeQuery(); // 표
		    	//	 가격이 낮은순으로
		    while( rset.next()){ //줄
				out.println("<tr><td>"+rset.getInt("mno")+
						    "</td><td>"+ rset.getString("mname")+
						    "</td><td>"+ rset.getInt("mprice")+		"</td></tr>"); //칸		    	
		    }
	    	//4. jdbc 연동끊기
		    	if(rset != null){rset.close();}
		    	if(pstmt != null){pstmt.close();}
/* 		    	if(pstmt1 != null){pstmt1.close();} */
		    	if(conn != null){conn.close();}
		    }catch(Exception a){ a.printStackTrace();}
		    %>
		    </tbody>
		  </table>
	</div>
<!--       주문현황표             -->
<!--       주문현황표             -->
<!-- 
= MODEL
★ 다음과 같이 테이블을 준비해주세요!
mysql> desc milk_order;
+-------+--------------+------+-----+-------------------+-------------------+
| Field | Type         | Null | Key | Default           | Extra             |
+-------+--------------+------+-----+-------------------+-------------------+
| ono   | int          | NO   | PRI | NULL              | auto_increment    |
| oname | varchar(20)  | NO   |     | NULL              |                   |
| onum  | int          | NO   |     | NULL              |                   |
| odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| oip   | varchar(100) | NO   |     | NULL              |                   |
+-------+--------------+------+-----+-------------------+-------------------+
5 rows in set (0.00 sec)
create table milk_order(
	ono int not null primary key auto_increment,
	oname varchar(20) not null,
	onum int not null,
	odate datetime default current_timestamp,
	oip varchar(100) not null
);

desc milk_order;

-- Q1.  milk_order 값삽입.  insert 구문 완성    
insert into milk_order(oname, onum, oip) values('banana',1,'198.160.0.1');

-- Q2.  milk_order ono가 1인데이터 조회
select * from milk_order where ono=1; 

-- Q3.  milk_order 전체데이터조회
select * from milk_order;

-- Q4.  milk_order 해당번호의 이름과 갯수 수정
update milk_order set oname='choco' , onum=2 where ono=1;

-- Q5.  milk_order 해당번호의 데이터 삭제
delete from milk_order where onum=1;
set sql_safe_updates=0;

<!--		 주문삽입, 수정, 삭제	 -->
<!--		 주문삽입, 수정, 삭제	 -->

</body>
</html>