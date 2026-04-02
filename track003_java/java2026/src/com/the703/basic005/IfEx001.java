package com.the703.basic005;

import java.util.Scanner;

public class IfEx001 {

	public static void main(String[] args) {
		int a = 0; String result = "불합격";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("평균점수 입력 > ");a=sc.nextInt();
		
		if(a >= 60) { System.out.println("합격"); }
		else        { System.out.println("불합격");}
		
		if(a >= 60) { result = "합격";}
		System.out.println(result);
		
		// 삼항연산자       조건 ?  참 : 거짓
		String answer = a >=60 ? "합격" : "불합격";
		System.out.println(answer);
		
		System.out.println( a >= 60 ? "합격" : "불합격");
	}

}
