package com.the703.basic006;

public class RepeatEx004 {

	public static void main(String[] args) {
		char a='\u0000';
		
//		for(a='A'; a<='Z'; a++) {
//				 if(a=='E') {System.out.print(a+"\n");}
//			else if(a=='J') {System.out.print(a+"\n");}
//			else if(a=='O') {System.out.print(a+"\n");}
//			else if(a=='T') {System.out.print(a+"\n");}
//			else if(a=='Y') {System.out.print(a+"\n");}
//			else {System.out.print(a);}}
		
		for(a='A'; a<='Z'; a++) {
//			 if(a=='E') {System.out.print(a+"\n");}
//		else if(a=='J') {System.out.print(a+"\n");}
//		else if(a=='O') {System.out.print(a+"\n");}
//		else if(a=='T') {System.out.print(a+"\n");}
//		else if(a=='Y') {System.out.print(a+"\n");}
		if(a%5==0) {System.out.println();	} 
		System.out.print(a);}
		
		a='A';
		while( a<='Z' ) {if(a%5==0) {System.out.println();	} 
		System.out.print(a);a++;}
		
		a='A';
		do {if(a%5==0) {System.out.println();	} 
		System.out.print(a);a++;} while( a<='Z' );


	}

}
