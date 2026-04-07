package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx002 {
	public static void main(String[] args) {
		//변수
		int a=0;
		
		//입력 예) 2단입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 2~9단 중 원하는 숫자입력 > "); a=sc.nextInt();
		//처리 + 출력
		//  2*1=2  System.out.printf("%d*%d=%d" , 2,1,2*1 );
		//  2*2=4  System.out.printf("%d*%d=%d" , 2,2,2*2 );
		//  2*3=6  System.out.printf("%d*%d=%d" , 2,3,2*3 );
		 if(a==2) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 2,i,2*i );}}
		 if(a==3) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 3,i,3*i );}}
		 if(a==4) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 4,i,4*i );}}
		 if(a==5) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 5,i,5*i );}}
		 if(a==6) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 6,i,6*i );}}
		 if(a==7) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 7,i,7*i );}}
		 if(a==8) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 8,i,8*i );}}
		 if(a==9) {for(int i=1; i<=9; i++) { System.out.printf("%d*%d=%d\n" , 9,i,9*i );}}
		 else {System.out.println("구구단에 포함된 숫자가 아닙니다.");}
		
 	}

}
//출력내용 :   for 이용
//사용자에게 구구단을 입력받아 해당하는 
//구구단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.