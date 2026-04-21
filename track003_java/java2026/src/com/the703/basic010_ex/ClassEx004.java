package com.the703.basic010_ex;

import java.util.Scanner;

class TV{
	String channel;
	int volume;   
	
	public TV() { super(); }
	public TV(String channel, int volume) { super(); this.channel = channel; this.volume = volume; }
	@Override public String toString() { return "TV [channel=" + channel + ", volume=" + volume + "]"; }
	//행위-멤버함수  : 채널, 볼륨
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("* channel 입력>");channel=sc.next();
		System.out.print("* volume 입력>");volume=sc.nextInt();
	}
	void show() {
		System.out.println(channel+"\t"+volume);}
	}


public class ClassEx004 {
	public static void main(String[] args) {
		 
		TV  t1 = new TV("JDBC" , 8);
		   t1.show(); 
		   TV  t2 = new TV();
		   t2.input();  
		   t2.show();
	}
}
