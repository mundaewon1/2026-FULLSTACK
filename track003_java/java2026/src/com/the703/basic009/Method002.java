package com.the703.basic009;

public class Method002 {
	// 1.		 리턴값   메서드명(파라미터:재료 ★)
	//					hello("고양이");
	public static void  hello(String name) {	// String name = "고양이"
		System.out.println("Hello~" + name);		
	}	
	//					icecream(     1 )
	public static void  icecream(int num) {
		System.out.println("아이스크림 " + num + "개");
	}
	
	//////////////////////////////////////////////////
	public static void main(String[] args) {

		hello("고양이");
		hello("alpha");

		icecream(1);
		icecream(2);

		info("sally" , 10);  // sally 최종 10점
		info("alpha" , 9);	 // alpha 최종  9점
		// public static 결과물 마법상자이름(재료) { }
		// 	public static void  info(String name, int num) { sally 최종 10점 }
	}
	//////////////////////////////////////////////////
	
	public static void  info(String name, int num) {
		System.out.printf("%s 최종 %d점 \n", name, num);
	}
	
}
