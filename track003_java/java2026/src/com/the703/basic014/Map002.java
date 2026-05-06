package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Map002 {
	public static void main(String[] args) {
		Map<String, UserDto> maps = new HashMap<>();
		maps.put("first", new UserDto("first@gamil.com"));
		maps.put("second", new UserDto("second@gamil.com"));
		maps.put("third", new UserDto("third@gamil.com"));
		maps.put("third", new UserDto("33@gamil.com"));
		maps.put("third", new UserDto("33@gamil.com"));

		System.out.println("몇명? " + maps.size());	//3
		System.out.println("몇명? " + maps);  
		//{ three=UserDto  [no=5, email=33@gamil.com], 
		//  first=UserDto  [no=1, email=first@gamil.com],
		//  second=UserDto [no=2, email=second@gamil.com]  }
		//1. maps.entrySet() 이용해서 향상된 for로 출력
		for(Entry<String, UserDto> u : maps.entrySet()) {
			String  key   = u.getKey();
			UserDto value = u.getValue();
			System.out.println("nickname : " + key + " , email : " + value.getEmail());
		}
		
		//2. maps.entrySet() 이용해서 향상된 Iterator로 출력  (iterator() , hasNext(), next())
		Iterator<Entry<String, UserDto>> iter = maps.entrySet().iterator();	 //줄서기
		while(iter.hasNext()) {  //처리대상확인
			Entry<String, UserDto> m = iter.next();
			String  key   = m.getKey();
			UserDto value = m.getValue();
			System.out.println("nickname : " + key + " , email : " + value.getEmail());
		}
		
		
		
	}
}
