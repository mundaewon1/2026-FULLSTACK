package com.the703.basic010_ex;

class Coffee{
	String name;
	int   num,price;
	
	public Coffee() { super();
	this.name = "아메리카노"; this.num = 1; this.price = 2000;}
	public Coffee(String name, int num, int price) { super(); this.name = name; this.num = num; this.price = price; }
	@Override public String toString() { return "Coffee [name=" + name + ", num=" + num + ", price=" + price + "]"; }

	void show(){System.out.println("=====커피\r\n"
			+ "커피명 : "+name+"\r\n"
			+ "커피잔수 : "+num+" \r\n"
			+ "커피가격 : "+(price*num));}
	}

public class ClassEx003 {
	public static void main(String[] args) {
		
			Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  		  a1.show();
			//Coffee a2 = new Coffee("아메리카노",1 , 2000);           a2.show();
			Coffee a2 = new Coffee();                     a2.show();
	}
}

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]	Coffee.class	ClassEx003.class
------------------------------------
[HEAP:동적]           					 |  [STACK:지역]
2번지:{ name="아메리카노", num=1, price=2000, show()}		<-	 a2 [2번지]
1번지:{ name="까페라떼", num=2, price=4000, show()}		<-	 a1 [1번지]
											 main
------------------------------------
*/
//////////////////////////////////////////////////////