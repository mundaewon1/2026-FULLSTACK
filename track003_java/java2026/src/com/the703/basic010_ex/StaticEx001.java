package com.the703.basic010_ex;

//1. 클래스는 부품객체이다
//2. 상태(멤버변수 : 인스턴수변수, 클래스변수-static)와 행위(인스턴스메서드, 클래스 메서드-static)
class Area1{
	//Areal.pi			(클래스변수- static)
	//Areal.rect(10, 5) (클래스메서드 - static)
	static double pi=3.14159;

	public static double rect(int a, double b)			 {return a*b;}
	public static double triangle(int a, double b)		 {return (a*b)/2;}
}

public class StaticEx001 {
	public static void main(String[] args) {
		   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
		   //							public static 리턴값 메서드명()
		   //							public static 50.0 rect(10, 5){	사각형의 면적}
		   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
		   //							public static 리턴값 메서드명()
		   //							public static 25.0 triangle(10, 5){	삼각형의 면적}
	}
}
