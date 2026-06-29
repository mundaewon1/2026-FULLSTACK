package com.the703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private Integer appUserId;
	private String  email;
	private String  password;
	private Integer mbtiTypeId;
	private String  createdAt;
	private String  ufile;
	private String  mobile;
	private String  nickname;
	private String  provider;
	private String  providerId;
}
/*
create table appuser(
APP_USER_ID                               NUMBER(5) primary key NOT NULL ,
EMAIL                                     VARCHAR2(100) NOT NULL ,
PASSWORD                                           VARCHAR2(100),
MBTI_TYPE_ID                                       NUMBER(3),
CREATED_AT                                         DATE,
UFILE                                              VARCHAR2(255),
MOBILE                                             VARCHAR2(50),
NICKNAME                                           VARCHAR2(50),
PROVIDER                                  VARCHAR2(50) NOT NULL ,
PROVIDER_ID                                        VARCHAR2(100),
);
*/