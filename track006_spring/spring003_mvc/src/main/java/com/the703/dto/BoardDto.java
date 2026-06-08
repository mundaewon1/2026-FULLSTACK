package com.the703.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bhit;
	private String bip;
	private String bfile;
	
}
//bno	int	NO	PRI		auto_increment
//bname	varchar(20)	NO			
//bpass	varchar(50)	NO			
//btitle	varchar(1000)	NO			
//bcontent	text	NO			
//bdate	timestamp	NO		CURRENT_TIMESTAMP	DEFAULT_GENERATED
//bhit	int	NO		0	
//bip	varchar(50)	NO			