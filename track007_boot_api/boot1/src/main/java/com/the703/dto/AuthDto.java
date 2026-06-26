package com.the703.dto;

import lombok.Data;

@Data
public class AuthDto {
	private Integer authId;
	private String  email;
	private String  auth;
	private Integer appUserId;
}
/*create table authorities(
 AUTH_ID                                   NUMBER(5) NOT NULL ,
 EMAIL                                              VARCHAR2(255),
 AUTH                                      VARCHAR2(255) NOT NULL ,
 APP_USER_ID                                        NUMBER(5)
);
*/