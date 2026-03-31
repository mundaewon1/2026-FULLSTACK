package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx002 {

	public static void main(String[] args) {
		int kor, eng, math, total, level; double avg;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 입력 > ");kor=sc.nextInt();
		System.out.print("영어점수 입력 > ");eng=sc.nextInt();
		System.out.print("수학점수 입력 > ");math=sc.nextInt();
		
		//처리
		total=kor+eng+math;
		avg=total/3.0;		// 정수 / 실수(double)
		avg=total/3f;		// 정수 / 실수(float)
		avg=(double)total/3;  // 실수 / 정수
		
		// 99.67 -> 99.67/10 = 9.967 -> (int)9.967 -> 9
		level=(int)avg/10;
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":: GOOD  IT SCORE ::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("국어\t영어\t수학\t총점\t평균\t레벨");
		System.out.printf ("%d\t%d\t%d\t%d\t%.2f\t%d",kor,eng,math,total,avg,level);
	}

}
