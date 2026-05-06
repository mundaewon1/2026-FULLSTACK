package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		map.put("피구왕","통키");
		map.put("제빵왕","김탁구");
		map.put("요리왕","비룡");
		
		//System.out.println(map);
		
		System.out.print("KING을 입력하세요 > "); String name=sc.next();
//		for(Entry<String, String> u = map.entrySet()) {
//			
//		}
		
		System.out.println("==============================\r\n"
				+ name+"   NAME\r\n"
				+ "==============================");
//		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
//		while(iter.hasNext()) {
//			Entry<String, String> m = iter.next();
//			String key = m.getKey();
//			String value = m.getValue();
//			
//			System.out.print(key+"   "+value+"\r\n"
//					+ "---------------------\r\n");
//		}
//		System.out.println(name+"의 정보를 제공중입니다");
//		
//		System.out.print("이름을 입력하세요 > "); String name2=sc.next();
//			 if(name2.equals("피구왕")) {System.out.println("\nㅁ"+name2+" : "+map.get("피구왕"));}
//		else if(name2.equals("제빵왕")) {System.out.println("\nㅁ"+name2+" : "+map.get("제빵왕"));}
//		else if(name2.equals("요리왕")) {System.out.println("\nㅁ"+name2+" : "+map.get("요리왕"));}
//		else 						   {System.out.println("다시 확인해주세요");}
		
		for(String key : map.keySet()) {
			System.out.println( key + "\t" + map.get(key));
			System.out.println("---------------------");
		}
		
		System.out.print("이름을 입력하세요 > "); String name2=sc.next();
		 if(name2.equals("피구왕")) {System.out.println("\nㅁ"+name2+" : "+map.get("피구왕"));}
	else if(name2.equals("제빵왕")) {System.out.println("\nㅁ"+name2+" : "+map.get("제빵왕"));}
	else if(name2.equals("요리왕")) {System.out.println("\nㅁ"+name2+" : "+map.get("요리왕"));}
	else 						   {System.out.println("다시 확인해주세요");}

			System.out.println( map.containsKey(name2) ? // true, false
					"ㅁ" + name2+":"+ map.get(name2) : "찾으시는 분이 없어요~!");
	}
}
/**
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
2-1. 다음과 같이 출력
2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구
*/