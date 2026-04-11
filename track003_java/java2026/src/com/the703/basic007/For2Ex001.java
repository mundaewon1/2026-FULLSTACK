package com.the703.basic007;

public class For2Ex001 {

	public static void main(String[] args) {
		System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
		System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
		System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
		System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
		System.out.println();
		for(int i=1;i<=4;i++){System.out.print("★");}System.out.println();
System.out.println();
		for(int b=1;b<=4;b++)
		{for(int i=1;i<=4;i++){System.out.print("★");}System.out.println();}
	}

}
//ver-1 눈에 보이는 그대로
//System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#');System.out.println();
//System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#');System.out.println();
//System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#');System.out.println();
//System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#');System.out.println();
////ver-2 칸정리
//System.out.println();
//
//for(int i=1;i<=4;i++){System.out.print('#');}System.out.println();
////ver-3 층정리
//for(int a=1;a<=4;a++)
//
//{for(int i=1;i<=4;i++){System.out.print('#');}System.out.println();}
//

