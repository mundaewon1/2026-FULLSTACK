package com.the703.basic008_ex;

public class Array2Ex001 {

	public static void main(String[] args) {
		int[][] arr2={
				{100,200,300},
				{400,500,600}
			};

//		System.out.print(arr2[0][0]+"\t");
//		System.out.print(arr2[0][1]+"\t");
//		System.out.print(arr2[0][2]+"\t");
//		
//		System.out.print(arr2[1][0]+"\t");
//		System.out.print(arr2[1][1]+"\t");
//		System.out.print(arr2[1][2]+"\t");
//		
//		for(int kan=0;kan<=2;kan++){System.out.print(arr2[0][kan]+"\t");}
//		for(int kan=0;kan<=2;kan++){System.out.print(arr2[1][kan]+"\t");}
		
		for(int ch=0;ch<arr2.length;ch++) {
		for(int kan=0;kan<arr2[ch].length;kan++){
			System.out.print(arr2[ch][kan]+"\t");
		}
		System.out.println();
		}
	}

}


// 이중for+ length 이용해서 출력하기   
