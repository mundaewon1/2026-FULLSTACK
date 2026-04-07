package com.the703.days;

import java.util.Scanner;

public class Forln2 {

	public static void main(String[] args) {
		//변수
		// 자료형 : 기본형/참조형 (String)
		// 기본형 : 정수:byte(1)<short(2)/char(2)<int(4)*<long(8) / 실수 : float(4)<double(8)* / boolean 빼고 타입형변환가능
		int kor=102,eng=102,math=102,total=0; double avg=0;
		String hak,hab="합격",level="가",jang="";
		Scanner sc = new Scanner(System.in);
		//입력
		//    문자열: next() / 정수형(10) : nextInt() / 실수형(1.23) : nextDouble() / 문자: next().chartAt(0)
		System.out.print("학번 입력 > "); hak=sc.next();
		
		for(;;) {
			if(kor<0 || kor>100)
		{System.out.print("국어점수 입력 > ");kor=sc.nextInt();}
			else if(eng<0 || eng>100)
		{System.out.print("영어점수 입력 > ");eng=sc.nextInt();}
			else if( !(math>=0 && math<=100) )
		{System.out.print("수학점수 입력 > ");math=sc.nextInt();}
			else {break;}}
		//처리 - 연산자 먼저() 값(++,--,산술) 비교(>,<) 조건(%%, ||) 대입(=)
		//    - 제어문 (#if/ #switch) 반복(#for/while/do while)
		total=kor+eng+math;  // 1. 총점 구하기
		avg=total/3.0;		 // 2. 평균 구하기 (강제형변환) 정수/실수
		hab = avg <60? "불합격" : kor<40 || eng<40 || math<40 ? "불합격" : "합격";
			 if(avg<60 || kor<40 || eng<40 || math<40) {hab="불합격";}
			 if(avg>=95) {jang="장학생";}
		
		switch((int)avg/10) {
		case 10: case 9: level="수"; break;
		case 8: level="우"; break;
		case 7: level="미"; break;
		case 6: level="양"; break;
		default : level="가"; break;
		}
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
