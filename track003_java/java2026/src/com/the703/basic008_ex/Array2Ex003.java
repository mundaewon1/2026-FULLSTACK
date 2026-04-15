package com.the703.basic008_ex;

public class Array2Ex003 {

	public static void main(String[] args) {
		 int[][] arr = {
				   { 1, 1, 1,},
				   { 2, 2, 2,},
				   { 3, 3, 3,},
				   { 4, 4, 4,},
				 };
		 
		 int total=0;  double avg=0.0;
			for (int ch = 0; ch < arr.length; ch++) {
				for (int kan = 0; kan < arr[ch].length; kan++) {
					total = total + arr[ch][kan];	
				}
				
			}
			avg = (double) total / (arr.length * arr[0].length);
//		 total= arr[0][0] + arr[0][1]+ arr[0][2]+	 
//				arr[1][0] + arr[1][1]+ arr[1][2]+
//				arr[2][0] + arr[2][1]+ arr[2][2]+
//				arr[3][0] + arr[3][1]+ arr[3][2];		 

		 
		 
		 System.out.println("총점 : "+total);
		 System.out.println("평균 : "+avg);

	}

}
//1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//
//출력내용:
//총점 : 30
//평균 : 2.5