package com.the703.basic006;

public class RepeatEx001 {

	public static void main(String[] args) {
		// {반복}  {변수}  for(시작; 종료; 변화)
		
		// 1 2 3 4 5
		for(int i=1;i<=5;i++) {System.out.println(i);}
		
		int i=1;
		while( i<=5 ) {System.out.println(i); i++;}
		
		int i1=1;
		do {System.out.println(i1); i1++;} while( i1<=5 ) ;
		
		// 5 4 3 2 1
		for(int a=5;a>=1;a--) {System.out.println(a);}
		
		int a=5;
		while( a>=1 ) {System.out.println(a); a--;}
		
		int a1=5;
		do {System.out.println(a1); a1--;} while( a1>=1 );

		//JAVA1 JAVA2 JAVA3

		System.out.println("JAVA"+1);
		System.out.println("JAVA"+2);
		System.out.println("JAVA"+3);
		
		for(int b=1;b<=3;b++)		{ System.out.println("JAVA"+b);}
		
		int b=1;
		while(b<=3) {System.out.println("JAVA"+b); b++;}
		
		int b1=1;
		do {System.out.println("JAVA"+b1);b1++;} while(b1<=3) ;
	}

}
