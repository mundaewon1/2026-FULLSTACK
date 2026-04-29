package com.the703.basic014_ex;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=-1;
		List<String> numbers = new ArrayList<>();
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		
		System.out.print("숫자 1~3입력 >"); a=sc.nextInt();
		
		for(int i=1;i<=numbers.size();i++) {
		if (a==i) {System.out.println(numbers.get(i-1));}
		}
		
//		switch(a){
//		case 1 : System.out.println(numbers.get(0)); break;
//		case 2 : System.out.println(numbers.get(1)); break;
//		case 3 : System.out.println(numbers.get(2)); break;
//		}
		
//		for( String s : numbers.get(1)) { System.out.println(s);}

		if(a>=1 && a<=3) { System.out.println(numbers.get(a-1));}
		else			 { System.out.println("1,2,3 중에 입력하세요.");}
	}
}
/**
1.  numbers ArrayList 만들기
2.  one, two, three 데이터 추가
3.  사용자에게 1,2,3 입력받기
4.  1을 입력받으면 one 출력
    2를입력받으면 two 출력
    3을입력받으면 three 출력
*/