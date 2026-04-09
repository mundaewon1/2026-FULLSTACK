package com.the703.basic007;

public class For2Ex002 {

	public static void main(String[] args) {
		System.out.print('@');	System.out.print('#');	System.out.print('#');	System.out.print('#');System.out.println();
		System.out.print('#');	System.out.print('@');	System.out.print('#');	System.out.print('#');System.out.println();
		System.out.print('#');	System.out.print('#');	System.out.print('@');	System.out.print('#');System.out.println();
		System.out.print('#');	System.out.print('#');	System.out.print('#');	System.out.print('@');System.out.println();
		System.out.println(); 
//		for(int a=1;a<=4;a++) {
//			
//		for(int i=1;i<=4;i++){
//		if(i==1 || i==5 || i==9 || i==13){System.out.print('@');}
//		else {System.out.print('#');}
//		} System.out.println();
//		
//		}
							  // 4번출력 - 첫번째 자리에 오면 @
		for(int i=1;i<=4;i++){System.out.print( i==1? '@' : '#');} System.out.println();
							  // 4번출력 - 2번째 자리에 오면 @
		for(int i=1;i<=4;i++){System.out.print( i==2? '@' : '#');} System.out.println();
							  // 4번출력 - 3번째 자리에 오면 @
		for(int i=1;i<=4;i++){System.out.print( i==3? '@' : '#');} System.out.println();
							  // 4번출력 - 4번째 자리에 오면 @
		for(int i=1;i<=4;i++){System.out.print( i==4? '@' : '#');} System.out.println();
		System.out.println();
		
		//for(int i=1;i<=4;i++){System.out.print( i==1? '@' : '#');if(i==1 || i==2 || i==3 || i==4) {i+1;}}
		for(int a=1;a<=4;a++)
		{for(int i=1;i<=4;i++){System.out.print( i==a? '@' : '#');} System.out.println();}
		
		
	}

}
