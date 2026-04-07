package com.the703.basic006_ex;

public class ForEx003 {

	public static void main(String[] args) {
		int hap=0;
		//  1+2+3+4+5+6+7+8+9+10=55
		for(int i=1;i<=10;i++) {hap=hap+i;}
		System.out.println(hap);
		
		{}

		//hap[누적박스:0] -> hap=0		 0
		//hap[누적박스:1] -> hap=1		 0+1			hap=hap+1
		//hap[누적박스:3] -> hap=3		(0+1)+2			hap=hap+2
		//hap[누적박스:6] -> hap=6		(0+1+2)+3		hap=hap+3
	}

}
//출력내용 :   for 이용
//1~10까지의 합을 구하시오.  55
//
//upgrade)  시간나면 도전!
//1+2+3+4+5+6+7+8+9+10=55
