package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int z = 0; int x = 0;
		//if(ch[0]=='B'){count}
		//if(ch[0]=='a' || ch[0]=='n'){count}
		
		for(int a=0;a<ch.length;a++) {
			 if(ch[a]>='A' && ch[a]<='Z') {z=z+1;}
		else if(ch[a]>='a' && ch[a]<='z') {x=x+1;}
		}
		
		System.out.println("대문자 갯수 "+z);
		System.out.println("소문자 갯수 "+x);
	}

}
//패키지명 : com.the703.basic008_ex
//클래스명 :  ArrayEx005
//    1. 배열명 : ch
//    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
//    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트