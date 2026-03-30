package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
	 	   1-1.  나이를 입력받을 자료형 선택후  변수명  age로 하시오.  예) 10,20
	   	   1-2.  Scanner이용해서 나이 입력받고 출력하시오.
	*/
		int age; 
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 나이를 입력하시오 > "); age=sc.nextInt();
		System.out.println("내 나이는 "+age+"입니다.");
		System.out.print("내 나이는 "+age+"입니다.\n");
		System.out.printf("%s%d%s","내 나이는 ",age,"입니다.");
		
	}

}
