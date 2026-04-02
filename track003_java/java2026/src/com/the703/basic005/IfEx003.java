package com.the703.basic005;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자 입력 > "); a=sc.nextInt();
		
			 if (a == 1) { System.out.println("one");}
		else if (a == 2) { System.out.println("two");}
		else if (a == 3) { System.out.println("three");}
		else             { System.out.println("1,2,3이 아니다");}

		System.out.println(a==1? "one" : (a==2? "two" : (a==3? "three" : "1,2,3이 아니다")));
		}
	}
