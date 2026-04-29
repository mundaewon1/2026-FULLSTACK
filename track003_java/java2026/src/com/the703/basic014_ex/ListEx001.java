package com.the703.basic014_ex;

//1. 동적배열 : 콜렉션프레임워크
//List, Set, Map
//List(기차) : 순서(index) o, 중복 o
//add, get, size, remove, contains
import java.util.ArrayList;
import java.util.List;

public class ListEx001 {
	public static void main(String[] args) {
			 
		List<String> colors = new ArrayList<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		colors.add("blue"); // 중복허용 o
		
		for(int i=0;i<colors.size();i++) {
			System.out.println(colors.get(i));
			}
		
		System.out.println();
		for( String c : colors) { System.out.println(c);}
			 
	}
}
/**
1. ArrayList이용해서 colors 만들기
2. red, green, blue 데이터 추가
3. 출력

red
green
blue
*/