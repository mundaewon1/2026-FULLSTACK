package com.the703.days;

public class DDD {

	public static void main(String[] args) {
		
		for(int i=3;i>=1;i--) {System.out.print(i+"\t");}
		System.out.println();
		
		int i=3;
		while(i>=1) {System.out.print(i+"\t");i--;}
		System.out.println();
		
		int i1=3;
		do {System.out.print(i1+"\t");i1--;} while(i1>=1);
		System.out.println();

//		for(int a=1;a<=3;a++) {System.out.print("★");}System.out.println();
//		for(int a=1;a<=2;a++) {System.out.print("★");}System.out.println();
//		for(int a=1;a<=1;a++) {System.out.print("★");}System.out.println();
		
		for(int b=3;b>=1;b--) {
		for(int a=1;a<=b;a++) {System.out.print("★");} System.out.println();}
		
		char [] arr = new char[3];
		char data='A';

		for(int x=0;x<arr.length;x++) {arr[x]=data; data+=1;}
		for(int x=0;x<arr.length;x++) {System.out.print(arr[x]+"\t");}
		
	}

}
