package com.the703.days;

import java.util.Scanner;

public class Day008 {

	public static void main(String[] args) {
		//변수
		int kor=-1,eng=-1,math=-1,total=0; double avg=0;
		String hak,hab="합격",level="가",jang="";
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("학번 입력 > "); hak=sc.next();
		
		for(;;) {System.out.print("국어점수 입력 > ");kor=sc.nextInt();
		System.out.print("영어점수 입력 > ");eng=sc.nextInt();
		System.out.print("수학점수 입력 > ");math=sc.nextInt();
		if( kor  >=0 && kor  <=100 &&
			eng  >=0 && eng  <=100 &&
			math >=0 && math <=100) {break;}}

		total=kor+eng+math;
		avg=total/3.0;
		
			 if(avg<60 || kor<40 || eng<40 || math<40) {hab="불합격";}
			 if(avg>=95) {jang="장학생";}
			 if(avg>=90) {level="수";}
		else if(avg>=80) {level="우";}
		else if(avg>=70) {level="미";}
		else if(avg>=60) {level="양";}
		//출력
		System.out.println("=====================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=====================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",hak,kor,eng,math,total,avg,hab,level,jang);
	}
}
//3. 필수조건
//System.out.println( x>=60 );
//System.out.println( ch=='a' ||  ch=='A' );
//System.out.println( ch>='0' &&  ch<='9' );
//System.out.println( ch>='A' &&  ch<='Z' );
