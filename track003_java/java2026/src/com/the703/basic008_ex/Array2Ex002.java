package com.the703.basic008_ex;

public class Array2Ex002 {

	public static void main(String[] args) {
		int [][] arr2 = new int [2][3];
		
		int data=101;

//		arr2[0][0]=data; data+=1; 
//		arr2[0][1]=data; data+=1; 
//		arr2[0][2]=data; data+=1; 
//
//		arr2[1][0]=data; data+=1; 
//		arr2[1][1]=data; data+=1; 
//		arr2[1][2]=data; data+=1; 
		
		for(int ch=0;ch<arr2.length;ch++) {
			for (int kan = 0; kan < arr2[ch].length; kan++) {
				arr2[ch][kan] = data;
				data += 1;
				System.out.print(arr2[ch][kan]+"\t");
			}
			System.out.println();
		}
		
	}

}

//101   102   103
//104    105    106