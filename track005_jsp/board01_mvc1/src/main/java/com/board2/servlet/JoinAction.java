package com.board2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public JoinAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 넘겨받기
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		//2. sql (드 커 프 리)
		Connection conn = null; PreparedStatement pstmt = null;
		String user = "root"; String pass = "1234";
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "insert into users  (nickname , bpass , email , mobile , bip) values(?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, bpass);
			pstmt.setString(3, email);
			pstmt.setString(4, mobile);
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());

		if(pstmt.executeUpdate() > 0 ) {
			out.println("<script> alert('회원가입 성공'); location.href='LoginAction'; </script>");
		}else { out.println("<script> alert('가입실패'); history.go(-1); </script>"); };

		if(pstmt != null) {pstmt.close();}
		if(conn != null) {conn.close();}
		}catch(Exception a) { a.printStackTrace();}
	}
}
