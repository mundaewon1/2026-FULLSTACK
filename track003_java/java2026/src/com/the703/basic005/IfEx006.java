package com.the703.basic005;

import java.util.Scanner;

public class IfEx006 {

	public static void main(String[] args) {
		int a=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력 > ");a=sc.nextInt();
		
			 if (a%2==1) {System.out.println("남자");}
		else if (a%2==0) {System.out.println("여자");}

	}

}
