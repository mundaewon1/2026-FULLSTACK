package com.the703.basic005;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		char a = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자 입력 > ");a=sc.next().charAt(0);
		
			 if (a>='A' && a<='Z') {System.out.println("대문자");}
		else if (a>='a' && a<='z') {System.out.println("소문자");}

		System.out.println(a>='A' && a<='Z'? "대문자":(a>='a' && a<='z'? "소문자":""));
	}

}
