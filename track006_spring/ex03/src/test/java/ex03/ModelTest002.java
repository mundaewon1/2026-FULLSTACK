package ex03;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  // 1. spirng 구동테스트
//@ContextConfiguration(locations = "classpath:config/*-context.xml")  // 2. 설정
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml" , "classpath:config/security-context.xml"})
public class ModelTest002 {
	@Autowired UserMapper user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	/*   security   */
	@Test public void test3() {

		/* 권한2개 - 회원, ADMIN */
		AuthDto dto1 = new AuthDto();	dto1.setEmail("a@a");
		System.out.println(user.readAuth(dto1));
		/* 권한2개 줬으면 주석달고 위에 해당유저정보가져오기 */
		/* 권한2개 - 회원, ADMIN */
		//AuthDto dto1 = new AuthDto();	dto1.setEmail("a@a");	dto1.setAuth("ROLE_MEMBER");
//		AuthDto dto1 = new AuthDto();	dto1.setEmail("a@a");	dto1.setAuth("ROLE_ADMIN");
//		System.out.println( user.insertAuth(dto1));  // ROLE_MEMBER , ROLE_ADMIN
		/* 회원가입시 암호화 성공했으면 주석달고 위에 권한실행 */
		/* 회원가입  (암호화) pwencoder.encode("a") */
//		UserDto dto = new UserDto();
//		dto.setNickname("a");			dto.setBpass( pwencoder.encode("a"));
//		dto.setEmail("a@a");	dto.setMobile("01011111111");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println(user.insert(dto));
	}
	
	@Ignore @Test public void test1() throws UnknownHostException {
		//이메일중복 : findByEmail - email - 중복(2개이상) 검색결과시 오류
		System.out.println(user.findByEmail("ㅇ"));
		
		//마이페이지 : findByUno   - uno
//		System.out.println(user.findByUno(9));
		
		//로그인    : findLogin     email=#{email} and bpass=#{bpass}
//		UserDto dto = new UserDto();
//		dto.setBpass("1111");		dto.setEmail("first@gmail.com");
//		System.out.println(user.findLogin(dto));
		
		//회원가입   : insert      - UserDto : nickname, bpass, email, mobile, bip
//		UserDto dto = new UserDto();
//		dto.setNickname("first");			dto.setBpass("1111");
//		dto.setEmail("first@gmail.com");	dto.setMobile("01011111111");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println(user.insert(dto));
	}

}
