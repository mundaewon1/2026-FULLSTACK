package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx004 {

	public static void main(String[] args) {
		char ex='\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자 입력 > ");ex=sc.next().charAt(0);
		
		
		switch(ex) {
		case 'a' : case 'A' : System.out.println("APPLE"); break;
		case 'b' : case 'B' : System.out.println("BANANA"); break;
		case 'c' : case 'C' : System.out.println("COCONUT"); break;
		}

	}

}
//연습문제4)  
//패키지명 : com.company.basic005_ex
//클래스명 :  SwitchEx004
//출력내용 :   switch 이용
//     문자한개 입력받아
//     a , A이면 APPLE
//     b , B이면 BANANA
//     c , C이면 COCONUT
