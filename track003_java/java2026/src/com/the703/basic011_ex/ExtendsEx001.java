package com.the703.basic011_ex;

/*	Object	#3 Object(){						}#4
	  ↑
	Color	#2 Color(){			name=null, num=0}#5
	  ↑
	Green	#1 Green(){					show()	}#6
	
	--------------------------------
	Green mygreen = new Green();
	--------------------------------
	1. Green은 Object(부품객체이다) Color는 Object(부품객체이다)
	2. 생성자호출 : Green() → Color() → Object()	 1 2 3
	3. 객체생성  : Object → Color → Green	 4 5 6
*/
class Color				 {
	public String name;
	private int num;
	
	public int getNum() { return num; }
	public void setNum(int num) { this.num = num; }
	
	public Color() { super(); }
	public Color(String name, int num) { super(); this.name = name; this.num = num; }
}
class Green extends Color{
	public Green() { super(); }
	public Green(String name, int num) { super(name, num); }

	void show() {
		System.out.println("GREEN");
		System.out.println("NAME : " + this.name);
		System.out.println("NUM : " + super.getNum());}
	}
	
public class ExtendsEx001 {
    public static void main(String[] args){
        Green mygreen = new Green();
        mygreen.name = "LIGHT_GREEN";
        mygreen.setNum(5);
        mygreen.show();
    }
}