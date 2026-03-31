package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner이용해서 파이값을 입력받고 출력하시오. 
     	파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
     	파이값은 **입니다.
		 */
		float a = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("파이값을 입력하시오 > "); a=sc.nextFloat();
		//처리 x
		System.out.println("파이값은 "+a+" 입니다.");
		System.out.print("파이값은 "+a+" 입니다.\n");
//		System.out.printf("파이값은 %f 입니다.", a);   숫자 무조건 붙일것
		System.out.printf("파이값은 %.0f 입니다.\n", a);//3
		System.out.printf("파이값은 %.1f 입니다.\n", a);//3.1
		System.out.printf("파이값은 %.2f 입니다.\n", a);//3.14
		System.out.printf("파이값은 %.6f 입니다.\n", a);//3.141592 7번째에 반올림됨

		System.out.println(10/3);   //정수/정수 = 정수
		System.out.println(10/3f);  //정수/실수 = 실수
		System.out.println(10f/3);  //실수/정수 = 실수
	}
}
