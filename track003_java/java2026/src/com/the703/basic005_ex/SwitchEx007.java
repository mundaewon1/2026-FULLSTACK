package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
		double a;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("평균 입력 > ");a=sc.nextInt();
		//switch(소수점 처리불가)
		switch((int)a/10) {
		case 9 : case 10 : System.out.println("수"); break;
		case 8 : System.out.println("우"); break;
		case 7 : System.out.println("미"); break;
		case 6 : System.out.println("양"); break;
		default : System.out.println("가"); break;
		}

	}

}
//클래스명 : SwitchEx007 
//출력내용 : switch 이용
//평균 한 개 입력받아
//    90~100점대면 수
//    80~90점(90점미만)대면  우
//    70~80점(80점미만)대면  미
//    60~70점(70점미만)대면  양
//    나머지 가