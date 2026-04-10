package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
		int a=0;  int avg=0;
		Scanner sc = new Scanner(System.in);
		
		//1.
		System.out.print("정수 입력 >"); a=sc.nextInt();
	
			 if(a>=90) {System.out.println("A 학점");}
		else if(a>=80) {System.out.println("B 학점");}
		else if(a>=70) {System.out.println("C 학점");}
		else 		   {System.out.println("F 학점");}

		//2.
	    System.out.print("평균입력 > ");  avg = sc.nextInt();
	    
	    switch(avg/10) {
	    case 9  : System.out.println("A 학점"); break;
	    case 8  : System.out.println("B 학점"); break;
	    case 7  : System.out.println("C 학점"); break;
	    default : System.out.println("F 학점"); break;}
	    
	    //3.
	    for(int b=1;b<=3;b++) {System.out.print(b+"\t");}
	    System.out.println();
	    
	    int b=1; while(b<=3) {System.out.print(b+"\t");b++;}
	    System.out.println();
	    
	    int b1=1; do {System.out.print(b1+"\t");b1++;} while(b1<=3);
	    System.out.println();
	    
	    //4.
//	    System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
//	    System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
//	    System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println();
//	    System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.print("★"); System.out.println(); 
//	  
//	    for(int c=1;c<=4;c++){System.out.print("★");} System.out.println();
//	    
	    for(int d=1;d<=4;d++){
	    for(int c=1;c<=4;c++){System.out.print("★");} System.out.println();}
	}

}
