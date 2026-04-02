package com.the703.basic005;//

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		int a, b; String c;
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력1 > ");a=sc.nextInt();
		System.out.print("정수 입력2 > ");b=sc.nextInt();
		System.out.print("연산자 입력 > ");c=sc.next();

			 if(c=="+") {System.out.println(a+b+"="+(a+b));}
		else if(c=="-") {System.out.println(a-b+"="+(a-b));}
		else if(c=="*") {System.out.println(a*b+"="+(a*b));}
		

		
		/*
		 연산자가 +라면 +
		 -라면 -
		 *라면 *
		 /라면 /
		 */

	}

}
