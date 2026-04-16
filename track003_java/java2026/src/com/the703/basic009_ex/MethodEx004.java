package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx004 {
	
	public static int			process_total(int kor, int eng, int math)  				{return kor+eng+math;}
	public static float			process_avg(int total)									{return total/3.0f;}
	public static String		process_pass(float avg, int kor, int eng, int math)		{return (avg<60 || kor<40 || eng<40 || math<40? "불합격" : "합격");}
	public static String		process_scholar(float avg)								{if(avg>=95) {return "장학생";}
																						 else  		 {return "";}}
	public static String		process_star(float avg)									{
//		return(avg>=100? "**********":avg>=90? "*********":avg>=80? "********":avg>=70? "*******":avg>=60? "******":
//			avg>=50? "*****":avg>=40? "****":avg>=30? "***":avg>=20? "**":avg>=10? "*":"");}
		String star="";
		for(int a=0;a<avg/10;a++) {star+="*";}
	return star;}
	
	public static void			process_show(String name,int kor,int eng,int math,int total,float avg,String pass,String jang,String star)
	{System.out.printf("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \r\n"
			+ "이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\r\n"
			+ "--------------------------------------------------------------------------------------------------\r\n"
			+ "%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s\r\n"
			+ "--------------------------------------------------------------------------------------------------"
			,name,kor,eng,math,total,avg,pass,jang,star);
	}
	////////////////////////////////////////////
	public static void main(String[] args) {
		   /////////////////////(1)  변수
	      String name  = ""; 
	      int kor, eng, math, total ;
	      float avg = 0.0f; 
	      String pass = "";
	      String jang = "";
	      String star= "";  
	      Scanner scanner = new Scanner(System.in);
	      
	      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
	      System.out.print("이름 입력 > ");name=scanner.next();
	      System.out.print("국어 입력 > ");kor=scanner.nextInt();
	      System.out.print("영어 입력 > ");eng=scanner.nextInt();
	      System.out.print("수학 입력 > ");math=scanner.nextInt();
	      /////////////////////(3) 처리 : 
	      total = process_total(kor , eng, math);    // 1. 총점처리
	      
	      avg = process_avg(total);    //2.  평균처리
	      
	      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/		불합격/재시험-각각 40미만인게 있다면  
	      pass = process_pass(avg , kor, eng, math);  
	      
	      //////// 4. 평균이 95점이상이면 장학생
	      jang = process_scholar(  avg  ); 
	      
	      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
	      star = process_star(avg);  
	      
	      
	      /////////////////////(4) 출력
	      process_show(name, kor, eng, math, total, avg, pass, jang, star);
	    

	}
	////////////////////////////////////////////
 
}
