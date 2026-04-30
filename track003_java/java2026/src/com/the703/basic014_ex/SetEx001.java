package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo2Dto{
	private String name;
	private int no;
	private int age;
	public UserInfo2Dto() { super(); }
	public UserInfo2Dto(String name, int no, int age) { super(); this.name = name; this.no = no; this.age = age; }
	@Override public String toString() { return "UserInfo2Dto [name=" + name + ", no=" + no + ", age=" + age + "]"; }
	
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getNo() { return no; } public void setNo(int no) { this.no = no; }
	public int getAge() { return age; } public void setAge(int age) { this.age = age; }
	@Override public int hashCode() { return Objects.hash(name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2Dto other = (UserInfo2Dto) obj;
		return Objects.equals(name, other.name);
	}
	
}

public class SetEx001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String find = "";	double avg=0;
		Set<UserInfo2Dto> users = new HashSet<>();
		users.add( new UserInfo2Dto("아이언맨" , 1 , 50));
		users.add( new UserInfo2Dto("헐크" , 2 , 40));
		users.add( new UserInfo2Dto("캡틴" , 3 , 120));
		users.add( new UserInfo2Dto("캡틴" , 3 , 120));
		
		for(UserInfo2Dto a: users) {
			System.out.println(a.getNo()+" - "+ a.getName()+" - "+ a.getAge());
			avg += a.getAge(); // 유저 나이 누적
			}
		
		System.out.println("> 찾을 유저이름 : ");	find = sc.next();
		
		// 만약 유저의 이름이 find 와 같다면 출력
		//System.out.println( users.contains( new UserInfo2Dto("아이언맨" , 1 , 50))? "o":"x");\

//		String aaa1 = "Apple";
//		String aaa2 = "Apple";
//		String bbb = new String("Apple");
//
//		System.out.println( System.identityHashCode(aaa1)   );
//		System.out.println( System.identityHashCode(aaa2)   );
//		System.out.println( System.identityHashCode(bbb)   );
//		System.out.println( aaa1 == bbb);
//		System.out.println( aaa1.equals(bbb));
		
		
		for(UserInfo2Dto a:users) {
			if(find.equals(a.getName())) {System.out.println(a); break;}
			if(a.getName().equals(find)) {System.out.println(a); break;}
		} //.equals() = 문자열 비교
		// 나이평균
		System.out.println("나이평균 > " + avg/users.size() );
		
	}
}
/**
1. UserInfo2    Dto 클래스만들기  - 속성 : private int no; private  String name; private  int age;
2. users   HashSet만들기
3. 다음의 데이터 넣기
   new UserInfo2(1, "아이언맨" , 50) , 
   new UserInfo2(2, "헐크" , 40) , 
   new UserInfo2(3, "캡틴" , 120), 
   new UserInfo2(3, "캡틴" , 120)
4. 향상된 for 이용해서 데이터 출력 (3명만 출력되게- 같은자료 중복안되게)
5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
6. 사용자들의 나이 평균처리

출력된 화면 : 
2 - 헐크 - 40
3 - 캡틴 - 120
1 - 아이언맨 - 50
> 찾을 유저이름 : 
캡틴
UserInfo2 [no=3, name=캡틴, age=120]
나이평균 > 70.0
*/