package com.the703.basic006;

import java.util.Scanner;

public class Forinfinit {

	public static void main(String[] args) {
		// 제어문
		// 조건문: ~라면  if  /  switch
		// 반복문:  반복  if  /  while  /  do while
		// 제어조건 :  break / continue
		
		//1.  영역
		//for(;;) {  System.out.println("Hello");   }

		Scanner sc = new Scanner(System.in);
		int a = -1;
		
		//2. 빠져나올조건
		for(;;)
		{
			System.out.println("Hello");
			System.out.println("빠져나오실래요?  0이면 종료");
			a = sc.nextInt();
			if(a==0) {break;}
		}
		//		int a = -1;  			//   a [  -  ]
		//		for( ;   a!=0   ; )		//   a가 0이면
		//		{
		//			System.out.println("Hello");
		//			System.out.println("빠져나오실래요?  0이면 종료");
		//			a = sc.nextInt();
		//		}// 여기까지 반복해
	}

}
