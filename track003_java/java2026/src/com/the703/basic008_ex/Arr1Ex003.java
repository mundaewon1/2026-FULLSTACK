package com.the703.basic008_ex;

import java.util.Arrays;

public class Arr1Ex003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		char [] ch1 = new char [26];
		//		char [] ch2 = new char [26];
		char [] ch = new char [52];
		char data1 = 'A';
		char data2 = 'a';
		int x1 = 0; int x2 = 0;
		
		for(int i=0;i<ch.length/2;i++) {
			ch[i]=data1; data1+=1;
			ch[i+26]=data2; data2+=1;
		}
//		for(int i=0;i<=25;i++) {System.out.print(ch1[i]);}

		System.out.println(Arrays.toString(ch));
//		for(int i=0;i<=25;i++) {System.out.print(ch2[i]);}
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i]=='A' || ch[i]=='A'+4 || ch[i]=='A'+8 || ch[i]=='A'+12 || ch[i]=='A'+16
			|| ch[i]=='a' || ch[i]=='a'+4 || ch[i]=='a'+8 || ch[i]=='a'+12 || ch[i]=='a'+16)
			{x1=x1+1;}}

		
		for(int e=0;e<=16;e++) {if(e%4==0 || e==0) {
		for(int i=0;i<ch.length;i++) {
			 if(ch[i]=='A'+e) 	{x2=x2+1;}
		else if(ch[i]=='a'+e) 	{x2=x2+1;}
		}
		}
		}
		
		System.out.println("모음의 개수는 "+ (x1));
		System.out.println("모음의 개수는 "+ (x2));
	}

}
