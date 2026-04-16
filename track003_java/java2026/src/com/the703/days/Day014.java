package com.the703.days;

import java.util.Scanner;

public class Day014 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력(1,2,3) > ");int day = sc.nextInt();

			 if (day==1) {System.out.println("1이다");}
		else if (day==2) {System.out.println("2이다");}
		else if (day==3) {System.out.println("3이다");}
		else 			 {System.out.println("1,2,3이 아니다");}
			 
		switch(day) {
		case 1 : System.out.println("1이다"); break;
		case 2 : System.out.println("2이다"); break;
		case 3 : System.out.println("3이다"); break;
		default : System.out.println("1,2,3이 아니다"); break;
		}
		
		for(int a=1;a<=4;a++) {System.out.print(a+"\t");}
		System.out.println();
		
		int a=1;
		while(a<=4) {System.out.print(a+"\t");a++;}
		System.out.println();		
		
		int a1=1;
		do {System.out.print(a1+"\t");a1++;}while(a1<=4);
		System.out.println();
		
		for(int c=1;c<=3;c++) {
		for(int b=1;b<=c;b++) {System.out.print("★");} System.out.println();}
		
		int [] arr2 = {1,2,3};
		
		System.out.println(arr2[2]);
		
		double [] arr = new double[5];
		double data=1.1;
		
		for(int x=0;x<arr.length;x++) {arr[x]=data; data++;}
		for(int x=0;x<arr.length;x++) {System.out.printf("%.1f\t",arr[x]);}
		
		
	}

}
