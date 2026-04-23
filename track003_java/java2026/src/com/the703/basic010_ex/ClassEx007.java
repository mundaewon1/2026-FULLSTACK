package com.the703.basic010_ex;

import java.util.Scanner;

class Calc{
	   int num1, num2;  char op;  double result;
	   
	   public Calc() { super(); }
	   public Calc(int num1, int num2, char op) { super(); this.num1 = num1; this.num2 = num2; this.op = op; this.result = result; }
	   @Override public String toString() { return "Calc [num1=" + num1 + ", num2=" + num2 + ", op=" + op + ", result=" + result + "]"; }
	   //행위-멤버함수  :  void input()   입력받기
	   // void opcalc()  +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
	   void input() {
		   Scanner sc = new Scanner(System.in);
		   System.out.print("\n숫자 1입력 > ");num1=sc.nextInt();
		   System.out.print("숫자 2입력 > ");num2=sc.nextInt();
		   System.out.print("연산자 입력 + - * / > ");op=sc.next().charAt(0);
	   }
       void opcalc() {if(op=='+') {result=num1+num2;}
							       else if(op=='-') {result=num1-num2;}
							       else if(op=='*') {result=num1*num2;}
							       else if(op=='/') {result=num1/(double)num2;}
       }
	   void show() {opcalc();
		   System.out.printf("%d%c%d=%.2f",num1,op,num2,result);}

	}

public class ClassEx007 {
	public static void main(String[] args) {
		   
		   Calc  c1= new Calc(10,3,'+');  
		   c1.show();
		   
		   Calc  c2= new Calc();  
		   c2.input();   
		   c2.show(); 
		   
	}
}
