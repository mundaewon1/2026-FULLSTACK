package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx003 {

	public static void main(String[] args) {
		char ex='\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자입력 > ");ex=sc.next().charAt(0);
		
		switch(ex) {
		case 'a': System.out.println("APPLE"); break;
		case 'b': System.out.println("BANANA"); break;
		case 'c': System.out.println("COCONUT"); break;
		}

	}

}
//패키지명 : com.company.basic005_ex
//클래스명 :  SwitchEx003
//출력내용 :   switch 이용
//     문자한개 입력받아
//     a이면 APPLE
//     b이면 BANANA
//     c이면 COCONUT