package com.the703.basic009_ex;

public class MethodEx002 {

	public static void test1(int num) {System.out.println(num);}
	
	public static void test2(double num) {System.out.println(num);}
	
	public static void hap(int num, int num2) {
		int box=0;
		for(int i=num;i<=num2;i++) {box+=i;}
		System.out.println(box);
	}
	
	public static void disp(int num, char ch) {for(int a=0;a<=num;a++) {System.out.print(ch);}}
	
	////////////////////////////////////////////////
	public static void main(String[] args) {
	    // public static  리턴값 메서드명(파라미터)
	     test1(10);    //10 출력
	     test2(1.2);   // 1.2 출력
	     hap(3,5);     // 3+4+5한값  12 출력
	     disp(7, '*');  // *******출력

	}
	///////////////////////////////////////////////

}
