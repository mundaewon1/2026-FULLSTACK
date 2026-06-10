package com.the703.dao;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper {
	public int     insert(UserDto dto);
	public int     findLogin(UserDto dto);
	public UserDto findByUno(int uno);
	public String  findByEmail(String email);
	
	/* security */
	public int         insertAuth(AuthDto dto);
	public AuthListDto readAuth(AuthDto dto);
	public UserDto findByEmailUserInfo(String email);
}

/*
create : 
    insert into users (nickname, bpass, email, mobile, bip)
    values            (#{nickname},#{bpass},#{email},#{mobile},#{bip})

read : 
    select count(*) from users where email=#{email} and bpass=#{bpass}
    select       *  from users where uno=#{uno}
    select    email from users where email=#{email}
    
    
    insert into authorities (email, auth) values (#{email},#{auth})
    
    select  u.email, u.bpass, a.auth
    from    users u left join authorities a  on u.email = a.email
    where   u.email = #{email}
 */