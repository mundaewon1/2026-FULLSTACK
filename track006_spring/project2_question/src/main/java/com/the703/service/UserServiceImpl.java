package com.the703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired  UserMapper dao;
	@Autowired  @Qualifier("passwordEncoder") PasswordEncoder  pwencoder;
	//import org.springframework.security.crypto.password.PasswordEncoder;

    @Override public int insert(UserDto dto) {
        // 1. 권한 추가 (기본 회원 권한)
        AuthDto adto = new AuthDto();   adto.setEmail(dto.getEmail());  adto.setAuth("ROLE_MEMBER");
        dao.insertAuth(adto);
        // 2. 비밀번호 암호화
        dto.setBpass(pwencoder.encode(dto.getBpass()));
        try { // 3. 가입 IP 저장
            dto.setBip(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } return dao.insert(dto);}

	    @Override public AuthUserDto readAuth(String email) { return dao.readAuth(email); }
	    @Override public int insertAuth(AuthDto dto) { return dao.insertAuth(dto); }
	    @Override public String findByEmail(String email) { return dao.findByEmail(email); }
	    @Override public UserDto findByEmailUserInfo(String email) { return dao.findByEmailUserInfo(email); }
	    @Override public UserDto findByNickname(String nickname) { return dao.findByNickname(nickname); }
}

