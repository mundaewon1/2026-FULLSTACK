package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {

	public static void main(String[] args) {
		int kor,eng,math,total=0; double avg=0;
		String hak,hab="합격",level="가",jang="";
		Scanner sc = new Scanner(System.in);

		System.out.print("학번 입력 > "); hak=sc.next();
		System.out.print("국어점수 입력 > "); kor=sc.nextInt();
		System.out.print("영어점수 입력 > "); eng=sc.nextInt();
		System.out.print("수학점수 입력 > "); math=sc.nextInt();
		
		total=kor+eng+math;
		avg=total/3.0;
				 if(avg<60 || kor<40 || eng<40 || math<40 ) {hab="불합격";}
				 if(avg>=95) {jang="장학생";}
				 if(avg>=90) {level="수";}
			else if(avg>=80) {level="우";}
			else if(avg>=70) {level="미";}
			else if(avg>=60) {level="양";}
		

		System.out.println("=================================================================================== ");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=================================================================================== ");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",hak,kor,eng,math,total,avg,hab,level,jang);

	}

}
