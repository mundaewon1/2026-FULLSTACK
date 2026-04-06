package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002 {

	public static void main(String[] args) {
		int a=2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자입력 > ");a=sc.nextInt();
		
		switch(a/3) {
			//   3/3=1(몫)    4/3=1(몫)   5/3=1(몫)
			case 1: System.out.println("봄"); break;
			//   6/3=2(몫)    7/3=2(몫)   8/3=2(몫)
			case 2: System.out.println("여름"); break;
			//   9/3=3(몫)    9/3=3(몫)   9/3=3(몫)
			case 3: System.out.println("가을"); break;
			//   1/3=0(몫)    2/3=0(몫)   12/3=4(몫)
			case 0: case 4: System.out.println("겨울"); break;
		}

	}

}
//연습문제2)  
//패키지명 : com.company.java004_ex
//클래스명 :  SwitchEx002
//출력내용 :   switch 이용
//     숫자한개 입력받아
//     3,4,5이면 봄
//     6,7,8이면 여름
//     9,10,11이면 가을
//     12,1,2이면 겨울