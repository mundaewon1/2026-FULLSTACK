package com.the703.dto;

import lombok.Data;
// dto 积己, mybatis dto 楷搬, config user-mapper 积己, dao UserMapper 积己 -> root-context.xml 楷搬
// test 积己 -> service,Impl 积己(惑加)-> Impl 

@Data
public class UserDto {
	private int uno;
	private String nickname;
	private String bpass;
	private String email;
	private String mobile;
	private String udate;
	private String bip;
}

//uno	int	NO	PRI		auto_increment
//nickname	varchar(20)	NO			
//bpass	varchar(50)	NO			
//email	varchar(100)	NO			
//mobile	varchar(50)	NO			
//udate	timestamp	YES		CURRENT_TIMESTAMP	DEFAULT_GENERATED
//bip	varchar(50)	NO			