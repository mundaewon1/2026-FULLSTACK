package com.the703.basic007;

import java.util.Scanner;

public class For2Ex0011 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
//		if(6==1+1) {System.out.println(1+"+"+1+"="+6);}
//		if(6==1+2) {System.out.println(1+"+"+2+"="+6);}
//		if(6==1+3) {System.out.println(1+"+"+3+"="+6);}
//		if(6==1+4) {System.out.println(1+"+"+4+"="+6);}
//		if(6==1+5) {System.out.println(1+"+"+5+"="+6);}
//		if(6==1+6) {System.out.println(1+"+"+6+"="+6);}
		
		for(int a=1;a<=6;a++) {if(6==1+a) {System.out.println(1+"+"+a+"="+6);}}
		for(int a=1;a<=6;a++) {if(6==2+a) {System.out.println(2+"+"+a+"="+6);}}
		for(int a=1;a<=6;a++) {if(6==3+a) {System.out.println(3+"+"+a+"="+6);}}
		for(int a=1;a<=6;a++) {if(6==4+a) {System.out.println(4+"+"+a+"="+6);}}
		for(int a=1;a<=6;a++) {if(6==5+a) {System.out.println(5+"+"+a+"="+6);}}
		System.out.println();
		
		for(int b=1;b<=6;b++) {
		for(int a=1;a<=6;a++) {if(6==b+a) {System.out.println(b+"+"+a+"="+6);}}}
		System.out.println();
		
		int b=1;
		while(b<=6) {
		int a = 1; while(a<=6) {if(6==b+a) {System.out.println(b+"+"+a+"="+6);}a++;};b++;}	
		System.out.println();
		
		int b1=1;
		do {

		int a = 1; while(a<=6) {if(6==b1+a) {System.out.println(b1+"+"+a+"="+6);}a++;};b1++;} while(b1<=6);




//		if(b==2+1) {System.out.println(2+"+"+1+"="+b);}
//		if(b==2+2) {System.out.println(2+"+"+2+"="+b);}
//		if(b==2+3) {System.out.println(2+"+"+3+"="+b);}
//		if(b==2+4) {System.out.println(2+"+"+4+"="+b);}

	}

}
//두개의 주사위를 던졌을때 눈의 합이 6
//1+5=6
//2+4=6
//3+3=6
//4+2=6
//5+1=6
// x+y=b => (x+y)==b