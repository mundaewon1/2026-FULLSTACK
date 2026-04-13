package com.the703.basic008_ex;

public class Arr1Ex004 {

	public static void main(String[] args) {
		char [] ch = {'B', 'a', 'n', 'a', 'n', 'a'}; // 6 :0~5
		
		
		for (int a = 0; a < ch.length; a++) {
			if (ch[a] >= 'A' && ch[a] <= 'Z') {
				ch[a] = (char) (ch[a] + 32);

			} else if (ch[a] >= 'a' && ch[a] <= 'z') {
				ch[a] = (char) (ch[a] - 32);

			} 
		}
		
		for (int a = 0; a < ch.length; a++) {
			//마지막이라면 "'%c'" 아니라면 "'%c',"
			System.out.printf((a==ch.length - 1? "'%c'":"'%c',"), ch[a]);
//			
//			if (ch[a] >= 'A' && ch[a] <= 'Z') {
//				System.out.printf("'%c',", ch[a]);
//
//			} else if (ch[a] >= 'a' && ch[a] <= 'z' && ch[a] <= ch[ch.length - 2]) {
//				System.out.printf("'%c',", ch[a]);
//
//			} else if (ch[a] == ch[ch.length - 1]) {
//				System.out.printf("'%c'", ch[a]);
//			}
		}
	}

}
