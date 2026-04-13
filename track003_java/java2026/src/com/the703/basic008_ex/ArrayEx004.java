package com.the703.basic008_ex;

public class ArrayEx004 {

	public static void main(String[] args) {
		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'};
		int v=0;
		//B가 a라면 count
		//ch[0]가 a라면 count
		//if(ch[0]가 a라면) {count}
		
		for(int x=0;x<ch.length;x++) {
		if(ch[x]=='a') {v=v+1;}
		}
		System.out.println("a의 갯수 "+v );
	}

}
//1. 배열명 : ch
//2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
//3. ch 배열에서 a의 갯수 세기
//4. 출력된화면 :  a의 갯수 3    