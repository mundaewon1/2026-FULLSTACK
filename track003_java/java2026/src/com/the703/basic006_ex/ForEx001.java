package com.the703.basic006_ex;

public class ForEx001 {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++) 	{ System.out.println(i); }
		for(int i=5; i>=1; i--) 	{ System.out.println(i); }

		for(int i=1; i<=3; i++) 	{ System.out.println((i == 1? "" : ",") +"JAVA"+i); }
		for(int i=3; i>=1; i--) 	{ System.out.println((i == 3? "" : ",") +"HAPPY"+i); }

		for(int i=0; i<=2; i++)		{ System.out.println(i);}
		for(int i=0; i<=99; i++)	{ System.out.println(i);}
		for(int i=10; i>=1; i--)	{ System.out.println(i);}

		for(int i=0; i<=8; i+=2)	{ System.out.println(i);}
		for(int i=0; i<=18; i+=2)	{ System.out.println(i);}
	}

}
