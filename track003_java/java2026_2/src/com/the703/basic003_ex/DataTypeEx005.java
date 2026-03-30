package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {

		/*
		Scanner이용해서  성적처리를 입력받고 출력하시오.
		   국어점수를 입력하시오.  _입력받기    100 
		   영어점수를 입력하시오.  _입력받기    100 
		   수학점수를 입력하시오.  _입력받기    99

		   총점 :  299
		   평균 :  99.67 
		*/
		int kor,eng,math,total; double avg=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어점수를 입력하시오."); kor=sc.nextInt();
		System.out.println("영어점수를 입력하시오."); eng=sc.nextInt();
		System.out.println("수학점수를 입력하시오."); math=sc.nextInt();
		System.out.println();
		
		total=kor+eng+math;
		avg=total/3.0;
		
		System.out.println("총점 : "+total+"\n평균 : "+avg);
		System.out.print  ("총점 : "+total+"\n평균 : "+avg+"\n");
		System.out.printf("총점 :%d \n평균 : %.2f",total, avg);
	}
}
