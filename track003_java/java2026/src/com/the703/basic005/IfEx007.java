package com.the703.basic005;//

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		//변수
		int num1 = -1, num2 = -1; char ch='\u0000';
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.print("정수 입력 >");num1=sc.nextInt();
		System.out.print("정수 입력2 >");num2=sc.nextInt();
		System.out.print("연산자 입력 >");ch=sc.next().charAt(0);  // "a(0)b(1)c(2)"
		
		//처리
		
		
		//출력
		//		if(만약  + 라면){ 10+3=13  }
		// else if(만약  - 라면){ 10-3=7   } 
		// else if(만약  * 라면){ 10*3=30  } 
		// else if(만약  / 라면){ 10/3=3.33}
		
		//ver-1  출력서식맞추기 %d 정수, %.2f 실수
			 if(ch == '+') { System.out.println(num1 + "+" + num2 + "=" + (num1+num2));}
		else if(ch == '-') { System.out.println(num1 + "-" + num2 + "=" + (num1-num2));}
		else if(ch == '*') { System.out.println(num1 + "*" + num2 + "=" + (num1*num2));}
		else if(num2 != 0 && ch == '/') {
			System.out.printf("%d / %d = %.2f", num1, num2, num1/(double)num2);}
		
	}

}
