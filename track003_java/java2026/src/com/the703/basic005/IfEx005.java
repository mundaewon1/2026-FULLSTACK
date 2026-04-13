package com.the703.basic005;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {
		char a = '\u0000', b = '\u0000';
		Scanner sc = new Scanner(System.in);

		System.out.println("문자 입력 > ");a=sc.next().charAt(0);
		
		if (a >= 'A' && a <= 'Z') {
			b = (char) (a + 32);
			// a(97) = A(65) + 32
		} else if (a >= 'a' && a <= 'z') {
			b = (char) (a - 32);
			// A(65) = a(97) - 32
		}
		System.out.println(a + "를 변환" +b);
	}

}
	/*
	패키지명 : com.company.java004_ex
	클래스명 :  IfEx005
	출력내용 : 문자한개를 입력받아 
	   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
	   ※  a = 'A' + 32   
	*/