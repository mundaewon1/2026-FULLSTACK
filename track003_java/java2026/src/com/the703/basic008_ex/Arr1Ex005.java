package com.the703.basic008_ex;

public class Arr1Ex005 {

	public static void main(String[] args) {
		int [] su = {-3,5,-1,9,-7};
		int v=0; int v1=0;
		
		for(int a=0;a<su.length;a++) {
			 if (su[a]<0) {v=v+1;}
		else if (su[a]>0) {v1=v1+1;}
		}
		System.out.println("음수의 갯수는 "+v);
		System.out.println("양수의 갯수는 "+v1);
	}

}
