package com.the703.basic005;

import java.util.Scanner;

public class IfEx0072 {
	public static void main(String[] args) {
		//변수
		int num1=0,num2=0; 
		double result=0;
		char ch = '\u0000';
		
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("1.정수를 하나 입력해주세요 > "); num1 = sc.nextInt();
		System.out.print("2. 정수를 하나 입력해주세요 >"); num2 = sc.nextInt();
		System.out.print("3. 연산자를 입력해주세요(+,-,*,/) > "); ch = sc.next().charAt(0);
		//처리
		if     (ch=='+') { result = num1 + num2; }
		else if(ch=='-') { result = num1 - num2; }
		else if(ch=='*') { result = num1 * num2; }
		else if(ch=='/') { result = (double)num1 / num2; }
		//출력
	  	//  	System.out.printf("%d / %d = %d\n" , num1,ch,num2,(int)result);
	  	//  	System.out.printf("%d %s %d = %d\n" , num1,ch,num2,(int)result);
  	  	
		System.out.printf("%d %c %d = " + (ch =='/'? "%.2f" : "%.0f"),num1,ch,num2,result);
		
		
		
		
	}
}
