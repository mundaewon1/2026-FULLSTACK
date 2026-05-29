package com.board2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();  // HttpSession - 서버에 저장
		PrintWriter out = response.getWriter();		 // 출력구문  
		
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		
		//2. sql (드 커 프 리)
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String user = "root"; String pass = "1234";
		String url  = "jdbc:mysql://localhost:3306/mbasic";
		String sql  = "select count(*) cnt from users where bpass=? and email=?";
		int find    = -1;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bpass);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { find = rset.getInt("cnt"); }  // 아이디와 비번이 같은 유저는 1명
			//3. 해당 화면으로 넘기기
			if(find == 1) { session.setAttribute("email", email);
					out.println("<script>alert('로그인 성공'); location.href='MyAction'; </script>");
			}else { out.println("<script>alert('정보확인 바랍니다'); history.go(-1); </script>"); }
	

		if(rset != null) {rset.close();}
		if(pstmt != null) {pstmt.close();}
		if(conn != null) {conn.close();}
		}catch(Exception a) { a.printStackTrace();}
	}
}
