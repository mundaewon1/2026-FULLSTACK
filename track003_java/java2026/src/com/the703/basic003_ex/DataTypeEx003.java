package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {

		/*
		 Scanner이용해서 태어난 년도를 입력받아 나이 계산하기
		 태어난 년도를 입력하세요. >
		 2000
		 당신의 나이는 25살 입니다.
		 */
		int a = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("태어난 년도를 입력하세요. > "); a=sc.nextInt();
		
		a = 2026 - a;
		System.out.println("당신의 나이는 "+a+" 살 입니다.");
		System.out.print("당신의 나이는 "+a+" 살 입니다.\n");
		System.out.printf("%s%d%s" ,"당신의 나이는 ",a," 살 입니다.");
		
	}

}
