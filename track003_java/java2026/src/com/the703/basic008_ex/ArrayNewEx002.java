package com.the703.basic008_ex;

public class ArrayNewEx002 {

	public static void main(String[] args) {
		//변수
		char [] arr = new char[5];
		char data = 'A';
		//입력
		// arr[0]='A'; arr[1]='B'; arr[2]='C'; arr[3]='D'; arr[4]='E';
		//처리
		for(int i=0;i<arr.length;i++) {arr[i]=data++;} // data("A") 대입 ; ++ 빠져나와서 증가
		//출력
		for(int i=0;i<arr.length;i++) {System.out.print(arr[i]+"\t");}
	}

}
//new 연산자 이용해서 배열만들기
//1. 배열명 : arr     
//2. 값 넣기 : A   B   C   D   E    for+length 이용해보기
//3. for + length 로 출력
