package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Player{
	private String name;
	private int score;
	public Player() { super(); }
	public Player(String name, int score) { super(); this.name = name; this.score = score; }
	@Override public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	
	@Override public int hashCode() { return Objects.hash(name, score); }
	@Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; Player other = (Player) obj; return Objects.equals(name, other.name) && score == other.score; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getScore() { return score; }
	public void setScore(int score) { this.score = score; }
	
}

//List	: add, get, size, remove, contains
//Set	: add, 향상된 for/Iterator, size, remove, contains
//Map	: put, get(key), size, remove, contains

public class Day029 {
	public static void main(String[] args) { 
		List<Player> players = new ArrayList<>(); // 배열의 단점을 개선한 클래스, 객체만 저장가능 (동적배열)
		players.add( new Player ("Mario", 1200));
		players.add( new Player ("Luigi", 1500));
		players.add( new Player ("Peach", 1800));
		players.add( new Player ("Bowser", 900));
		players.add( new Player ("Bowser", 900));
		
		for(int b=0;b<players.size();b++) {
		for(Player a:players) {System.out.println(++b +"\t"+a.getName()+"\t"+a.getScore());};
		}
		
		//오름차순
		players.sort( new Comparator<Player>() {
			@Override public int compare(Player o1, Player o2) { 
				//return Integer.compare(o1.getScore(), o2.getScore());}  오름차순
				return Integer.compare(o2.getScore(), o1.getScore());} // 내림차순
		});
		
		players.sort( (o1,o2) -> Integer.compare(o1.getScore(), o2.getScore()));
		
		players.sort( Comparator.comparingInt(Player::getScore));
		
		
		for(Player a :players) {
		System.out.println(a.getName()+"\t"+a.getScore());
		};
		
		Set<Player> setPlayers = new HashSet<>();
		setPlayers.add( new Player ("Mario", 1200));
		setPlayers.add( new Player ("Luigi", 1500));
		setPlayers.add( new Player ("Peach", 1800));
		setPlayers.add( new Player ("Bowser", 900));
		setPlayers.add( new Player ("Bowser", 900));
		
		Iterator<Player> iter = setPlayers.iterator();  // 1. 줄을 서시오
		int i=0;
		while(iter.hasNext()) {  //2. 처리대상 유무
			Player m = iter.next(); //3. 한개씩 꺼내오기
			System.out.println(++i+"\t"+m.getName()+"\t"+m.getScore());
		};
		
		Map<String,Player> mapPlayers = new HashMap<>();
		mapPlayers.put("mario", new Player("Mario", 1200));
		mapPlayers.put("luigi", new Player("Luigi", 1500));
		mapPlayers.put("peach", new Player("Peach", 1800));
		mapPlayers.put("bowser", new Player("Bowser", 900));
		
		for(Entry<String, Player> a : mapPlayers.entrySet()) {
			System.out.println(a.getKey()+"\t"+a.getValue().getName()+"\t"+a.getValue().getScore());
		}
		

    }
}

/*
Q1. Player DTO 클래스 만들기
속성:
private String name;
private int score;

Q2. List (ArrayList) 출력
2-1. players 이름으로 ArrayList 만들기
2-2. 데이터 추가:
new Player("Mario", 1200),
new Player("Luigi", 1500),
new Player("Peach", 1800),
new Player("Bowser", 900)
new Player("Bowser", 900)

2-3. for + size 이용해서 출력

출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900
5   Bowser   900

Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
4   Bowser   900
5   Bowser   900

List는 순서o 중복o인 기차 구조라서

Q4. Set (HashSet) 출력
4-1. setPlayers 이름으로 HashSet 만들기
4-2. 동일한 데이터 넣기 (중복 허용 안됨)
4-3. Iterator 이용해서 출력
출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900

Q5. Map (HashMap) 출력
5-1. mapPlayers 이름으로 HashMap 만들기
5-2.  데이터 넣기 (Key-Value 구조)
mapPlayers.put("mario", new Player("Mario", 1200));
mapPlayers.put("luigi", new Player("Luigi", 1500));
mapPlayers.put("peach", new Player("Peach", 1800));
mapPlayers.put("bowser", new Player("Bowser", 900));
5-3. for-each + entrySet 이용해서 출력
출력 예시
mario   Mario    1200
luigi   Luigi    1500
peach   Peach    1800
bowser  Bowser   900

Q6. 정렬 문제
6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
6-2. 람다식으로 점수 오름차순 정렬
6-3. 메서드 참조로 점수 오름차순 정렬

출력 예시 (오름차순)
코드
Bowser   900
Bowser   900
Mario    1200
Luigi    1500
Peach    1800
*/