package com.the703.basic010_ex;

import java.util.Scanner;

class MyPrice001{
	String name;
	int price;
	
	public MyPrice001() { super(); }
	public MyPrice001(String name, int price) { super(); this.name = name; this.price = price; }
	@Override public String toString() { return "MyPrice001 [name=" + name + ", price=" + price + "]"; }
	
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품이름 입력 >  "); name=sc.next();
		System.out.print("상품가격 입력 >  "); price=sc.nextInt();
	}
	void show() {System.out.println("상품정보입니다\n"
			+"상품이름 : "+name+" / 상품가격 : "+price);}
}

public class ClassEx002 {
	public static void main(String[] args) {
        
		MyPrice001   p1 = new MyPrice001();
		
        p1.input();		//1번지.input()
        p1.show();		//1번지.show()
        
	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]	MyPrice001.class , ClassEx002.class #1
------------------------------------
[HEAP:동적]           					 |  [STACK:지역]

1번지 MyPrice001 (객체,Object,instance)
{name=null, price=0, input(), show()}  <-    p1[1번지]
						 					 main #2
------------------------------------
*/
//////////////////////////////////////////////////////
