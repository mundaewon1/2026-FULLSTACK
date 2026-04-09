package com.the703.basic007;

public class For2Ex004 {

	public static void main(String[] args) {
		
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.println();
		
		for(int a=1;a<=4;a++) {System.out.print('#');} System.out.println();
		for(int a=1;a<=3;a++) {System.out.print('#');} System.out.println();
		for(int a=1;a<=2;a++) {System.out.print('#');} System.out.println();
		for(int a=1;a<=1;a++) {System.out.print('#');} System.out.println();
		
		for(int b=4;b>=1;b--) {
		for(int a=1;a<=b;a++) {System.out.print('#');}
		 System.out.println(); }
		
	}
}
//####
//###
//##
//#
