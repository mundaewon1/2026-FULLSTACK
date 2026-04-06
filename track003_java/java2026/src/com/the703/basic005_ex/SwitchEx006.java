package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx006 {

	public static void main(String[] args) {
		String ex="";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요일 입력 M,T,W,F,S,U > ");ex=sc.next();
		
		switch(ex.charAt(0)) {
		case 'M' : System.out.println("월요일: 공부하는 날"); break;
		case 'T' : System.out.println("화요일: 운동하는 날"); break;
		case 'W' : System.out.println("수요일: 독서하는 날"); break;
		case 'F' : System.out.println("금요일: 영화보는 날"); break;
		case 'S' : System.out.println("토요일: 여행가는 날"); break;
		case 'U' : System.out.println("일요일: 휴식하는 날"); break;
		}

	}

}
//연연습문제6)  
//패키지명 : com.company.basic005_ex  
//클래스명 : SwitchEx006  
//출력내용 : switch 이용
//문자 한 개 입력받아
//   M이면 "월요일: 공부하는 날"
//   T이면 "화요일: 운동하는 날"
//   W이면 "수요일: 독서하는 날"
//   F이면 "금요일: 영화 보는 날"
//   S이면 "토요일: 여행 가는 날"
//   U이면 "일요일: 휴식하는 날"