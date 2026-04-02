package com.the703.basic005;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		int a = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력 > ");a=sc.nextInt();
		
			 if (a > 0) { System.out.println("양수");} 
		else if (a < 0) { System.out.println("음수");}
		else            { System.out.println("zero");}

		System.out.println(a > 0 ? "양수" : (a<0? "음수":"zero") );
	}

}
