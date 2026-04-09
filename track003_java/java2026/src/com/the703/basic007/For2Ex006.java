package com.the703.basic007;

public class For2Ex006 {

	public static void main(String[] args) {
		System.out.print(1); System.out.println();
		System.out.print(2);System.out.print(2); System.out.println();
		System.out.print(3);System.out.print(3);System.out.print(3); System.out.println();
		System.out.print(4);System.out.print(4);System.out.print(4);System.out.print(4); System.out.println();
		System.out.println();
		
		for(int a=1;a<=1;a++) {System.out.print(1);} System.out.println();
		for(int a=1;a<=2;a++) {System.out.print(2);} System.out.println();
		for(int a=1;a<=3;a++) {System.out.print(3);} System.out.println();
		for(int a=1;a<=4;a++) {System.out.print(4);} System.out.println();
		System.out.println();
		
		for(int b=1;b<=4;b++) {
		for(int a=1;a<=b;a++) {System.out.print(b);} System.out.println();}
		
	}

}
//1
//22
//333
//4444
