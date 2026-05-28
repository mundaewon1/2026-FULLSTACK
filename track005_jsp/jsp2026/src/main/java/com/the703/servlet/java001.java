package com.the703.servlet;

public class java001 {
	private int a;
	private int b;
	
	public java001() { super(); }
	public java001(int a, int b) { super(); this.a = a; this.b = b; }
	@Override public String toString() { return "java001 [a=" + a + ", b=" + b + "]"; }

	public int getA() { return a; }
	public void setA(int a) { this.a = a; }
	public int getB() { return b; }
	public void setB(int b) { this.b = b; }
}
