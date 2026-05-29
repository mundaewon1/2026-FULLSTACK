package com.board2.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyAction
 */
@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MyAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 로그인한정보확인
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String email = (String) session.getAttribute("email");
		
		//2. sql- 내정보가져오기
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String user = "root"; String pass = "1234";
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users where email=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				request.setAttribute("nickname", rset.getString("nickname"));
				request.setAttribute("bpass", rset.getString("bpass"));
				request.setAttribute("email", rset.getString("email"));
				request.setAttribute("mobile", rset.getString("mobile"));
				request.setAttribute("udate", rset.getString("udate"));
				request.setAttribute("bip", rset.getString("bip"));
			}

		if(rset != null) {rset.close();}
		if(pstmt != null) {pstmt.close();}
		if(conn != null) {conn.close();}
		}catch(Exception a) { a.printStackTrace();}
		//3. mypage.jsp로 경로 넘기기
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
