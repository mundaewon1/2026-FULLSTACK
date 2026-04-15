package com.the703.basic008_ex;

public class Array2Ex004 {

	public static void main(String[] args) {
		
		int[][] datas = { 
				{  10, 10, 10 ,10},             
                {  20, 20, 20 ,20},     
                {  30, 30, 30 ,30},     
		}; 
		
		int[][] result = new int[datas.length+1][datas[0].length+1];    

		
		for (int ch = 0; ch < datas.length; ch++) {
			for (int kan = 0; kan < datas[ch].length; kan++) {
				result[ch][kan] = result[ch][kan] + datas[ch][kan];
				
				result [ch][4] = result [ch][4]+datas[ch][kan];
				
				result [3][kan] = result [3][kan]+datas[ch][kan];
				
				result [3][4]=result[3][4] +datas[ch][kan];
			}
		}
		
		for (int ch = 0; ch < datas.length + 1; ch++) {
			for (int kan = 0; kan < datas[0].length + 1; kan++) {
				System.out.print(result[ch][kan] + "\t");
			}
			System.out.println();
		}
		
//		result [0][4] = datas[0][0] + datas[0][1] + datas[0][2] + datas[0][3];
//		result [1][4] = datas[1][0] + datas[1][1] + datas[1][2] + datas[1][3];
//		result [2][4] = datas[2][0] + datas[2][1] + datas[2][2] + datas[2][3];
//		result [3][4] =
//		
//		result [3][0] = datas[0][0] + datas[1][0] + datas[2][0];			
//		result [3][1] = datas[0][1] + datas[1][1] + datas[2][1];			
//		result [3][2] = datas[0][2] + datas[1][2] + datas[2][2];			
//		result [3][3] = datas[0][3] + datas[1][3] + datas[2][3];
		
	}

}
//#1. result 에 datas데이터 복사하기
//#2. 가로방향누적데이터
//#3. 세로방향데이터누적
//#4. 총합
//
//출력내용:
//10   10   10   10   40   
//20   20   20   20   80   
//30   30   30   30   120   
//60   60   60   60   240   