package com.the703.service;

import com.the703.dto.UserDto;

public interface UserService {
	//1. 회원가입
	public int insert(UserDto dto);
	//2. 로그인
	public int findLogin(UserDto dto);
	//3. 마이페이지
	public UserDto findByUno(int uno);
	//4. 중복검사
	public String findByEmail(String email);
}
