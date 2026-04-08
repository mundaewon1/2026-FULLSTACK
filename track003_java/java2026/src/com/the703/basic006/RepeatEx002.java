package com.the703.basic006;

public class RepeatEx002 {

	public static void main(String[] args) {
		int hab=0; int hab2=0; int hab3=0;
		for(int i=1;i<=10;i++) {if( i%3==0) {hab=hab+i;}}
		System.out.println(hab);
		
		int i=1;
		while(i<=10) {if( i%3==0) {hab2=hab2+i;}i++;}
		System.out.println(hab2);
		
		int i1=1;
		do {if(i1%3==0) {hab3=hab3+i1;}i1++;} while(i1<=10);
		System.out.println(hab3);
			
		

	}

}
/*
for , while , do while 3가지 버젼으로 

		1~10까지 3의 배수의 합 : 18
for(1~10까지) {if(){3의 배수의 합(hab,hab2,hab3)}} : 18

힌트)
ver-1) 말로 풀어쓰기
1이  3의 배수라면  합을더해 변수에누적
2가  3의 배수라면  합을더해 변수에누적
3이  3의 배수라면  합을더해 변수에누적

ver-2) 구조 - 제어,반복
if( 1이  3의 배수라면 ){ 합을더해 변수에누적 }
if( 2가  3의 배수라면 ){ 합을더해 변수에누적 }
if( 3이  3의 배수라면 ){ 합을더해 변수에누적 }

ver-3) 코드
int hab=0;
if( 1%3==0 ){ hab=hab+1;}
if( 2%3==0 ){ hab=hab+2;}
if( 3%3==0 ){ hab=hab+3;}
*/