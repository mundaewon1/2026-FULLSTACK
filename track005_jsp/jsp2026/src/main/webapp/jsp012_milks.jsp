<%@ page import="java.sql.*"%>
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
	
	<div class="container card my-5 bg-primary text-white">
		<h2 class="card-header">Milk Order</h2>
		<table class="table table-white table-striped table-hover">
		<caption>주문현황표</caption>
		    <thead>
		      <tr>
		        <th scope="col">NO</th>
		        <th scope="col">NAME</th>
		        <th scope="col">NUM</th>
		        <th scope="col">DATE</th>
		      </tr>
		    </thead>
		    <tbody>
		  <%
		  try{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  ResultSet rset = null; Connection conn = null; PreparedStatement pstmt = null;
		  conn = DriverManager.getConnection(
				  "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
		  pstmt = conn.prepareStatement("select * from milk_order");
		  
		  rset = pstmt.executeQuery(); 	//표 select 
		  								//executeUpdate insert, update, delete
		  
		  while( rset.next() ){ // 줄
			  out.println("<tr><td>"+	rset.getInt("ono")+
					  	  "</td><td>"+	rset.getString("oname")+
					  	  "</td><td>"+	rset.getInt("onum")+
					  	  "</td><td>"+	rset.getString("odate")+"</td></tr>");
		  };

		  if(rset != null ){rset.close();}
		  if(pstmt != null ){pstmt.close();}
		  if(conn != null ){ conn.close();}
		  }catch(Exception a){ a.printStackTrace(); }
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

      <div class="container card my-5 bg-primary text-white">
		<h3 class="card-header">Milk 주문, 수정, 삭제</h3>
	   
	   <div id="accordion"> <!-- 부트스트랩 accordion -->

	  <div class="card">
	    <div class="card-header bg-info">
	      <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
	        주문하기
	      </a>
	    </div>
	    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		      <div class="card-body">
		        <form action="jsp012_insert.jsp" method="post" onsubmit="return ck()">
		        <div class="my-3">
		        	<label for="oname" class="form-label">주문할 우유이름</label>
		        	<Input type="text" class="form-control" id="oname" name="oname" />
		        </div>
		        <div class="my-3">
		        	<label for="onum" class="form-label">우유 개수</label>
		        	<Input type="text" class="form-control" id="onum" name="onum" />
		        </div>
		        
		        <div class="my-3">
		        	<button type="submit" class=" btn btn-warning"> 주문하기 </button>
		        </div>
	        	</form>
	        <!-- 
	        	1) form 만들기 2) 빈칸검사
	        	3) 처리해결사 jsp012_insert.jsp 데이터 노출x 보관용기 oname, onum
	         -->
	        <script>
	        function ck(){
	        	let oname = document.getElementById("oname");
	        	let onum = document.getElementById("onum");
	        	console.log(onum);
	        	if(oname.value.trim() ==""){ alert("우유이름을 입력해주세요"); oname.focus(); return false; }
        		if(onum.value.trim() ==""){console.log(onum.value.trim()); alert("우유개수를 입력해주세요"); onum.focus(); return false; }
	        	return true;
	        }
	        </script>
	        
	      </div>
	    </div>
	  </div>
	
	  <div class="card">
	    <div class="card-header  bg-info">
	      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
	        주문수정
	      </a>
	    </div>
	    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
	      <div class="card-body">
		       <form action="jsp012_update.jsp" method="post" onsubmit="return ck1()">
		        <div class="my-3">
		        	<label for="ono1" class="form-label">수정할 우유번호</label>
		        	<Input type="text" class="form-control" id="ono1" name="ono" />
		        </div>
		        <div class="my-3">
		        	<label for="oname1" class="form-label">수정할 우유이름</label>
		        	<Input type="text" class="form-control" id="oname1" name="oname" />
		        </div>
		        <div class="my-3">
		        	<label for="onum1" class="form-label">수정할 우유 개수</label>
		        	<Input type="text" class="form-control" id="onum1" name="onum" />
		        </div>
		        
		        <div class="my-3">
		        	<button type="submit" class=" btn btn-warning"> 수정하기 </button>
		        </div>
	        	</form>
	        	
	        <script>
	        function ck1(){
	        	let oname = document.getElementById("oname1");
	        	let onum = document.getElementById("onum1");
	        	if(oname.value.trim() ==""){ alert("우유이름을 입력해주세요"); oname.focus(); return false;}
        		if(onum.value.trim() ==""){ alert("우유개수를 입력해주세요"); onum.focus(); return false;}
	        return true;
	        };
	        </script>
	      </div>
	    </div>
	  </div>
	
	  <div class="card">
	    <div class="card-header  bg-info">
	      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
	        주문삭제
	      </a>
	    </div>
	    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
	      <div class="card-body">
	        <form action="jsp012_delete.jsp" method="post" onsubmit="return ck2()">
		        <div class="my-3">
		        	<label for="ono2" class="form-label">삭제할 우유번호</label>
		        	<Input type="text" class="form-control" id="ono2" name="ono" />
		        </div>
		        
		        <div class="my-3">
		        	<button type="submit" class=" btn btn-warning"> 삭제하기 </button>
		        </div>
	        	</form>
	        	
	        <script>
	        function ck2(){
	        	let oname = document.getElementById("oname2");
	        	if(oname.value.trim() ==""){ alert("우유이름을 입력해주세요"); oname.focus(); return false; }
	        return true;
	        };
	        </script>
	      </div>
	    </div>
	  </div>

		</div>
       </div>

</body>
</html>


