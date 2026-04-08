package com.the703.basic006;

public class RepeatEx003 {

	public static void main(String[] args) {
		int get=1; int get1=1; int get2=1;
		//System.out.println("3의 배수이면서 2의 배수인 숫자 : "+6);
		for (int i = 1; i <= 30; i++) {if (i%3 == 0 && i%2 == 0)
		{System.out.println(get+".3의 배수이면서 2의 배수인 숫자 : "+i); get = get + 1;}}
		System.out.println("갯수 : " + (get-1));
		
		int i = 1;
		while ( i <= 30 ) {if (i%3 == 0 && i%2 == 0)
		{System.out.println(get1+".3의 배수이면서 2의 배수인 숫자 : "+i); get1 = get1 + 1;}i++;}
		System.out.println("갯수 : " + (get1-1));
		
		int i1 = 1;
		do {if (i1%3 == 0 && i1%2 == 0)
		{System.out.println(get2+".3의 배수이면서 2의 배수인 숫자 : "+i1); get2 = get2 + 1;}i1++;}
		 while ( i1 <= 30 );
		System.out.println("갯수 : " + (get2-1));

	}

}
/* 1 2 3 4 5
1~30의 범위에서 3의 배수이면서 2의 배수인 숫자와 갯수를 구하는 프로그램 작성

3의 배수이면서 2의 배수인 숫자 : 6
3의 배수이면서 2의 배수인 숫자 : 12
3의 배수이면서 2의 배수인 숫자 : 18
3의 배수이면서 2의 배수인 숫자 : 24
3의 배수이면서 2의 배수인 숫자 : 30 갯수 :5

if(1이 3의 배수이면서 2의 배수라면){숫자출력,갯수카운트} 
if(i이 3의 배수이면서 2의 배수라면){syso("3의 배수이면서 2의 배수인 숫자 : "+i),get=get+1}
if(3이 3의 배수이면서 2의 배수라면){배수인 숫자, 배수의 갯수를 따로따로 출력}

if (i%3==0 && i%2==0) {"3의 배수이면서 2의 배수인 숫자 : "+i; get=get+1; }
*/