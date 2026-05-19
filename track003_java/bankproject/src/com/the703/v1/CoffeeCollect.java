package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// 1. 카페 적립금 DTO
class CafeDto {

    private String id;        // 회원명
    private String pass;      // 전화번호
    private double point;     // 포인트

    public CafeDto() { super(); }
    public CafeDto(String id, String pass, double point) { super(); this.id = id; this.pass = pass; this.point = point; }
    @Override public String toString() { return "CafeDto [id=" + id + ", pass=" + pass + ", point=" + point + "]"; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public double getPoint() { return point; }
    public void setPoint(double point) { this.point = point; }

    @Override public int hashCode() { return Objects.hash(id); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CafeDto other = (CafeDto) obj;
        return Objects.equals(id, other.id);
    }
}

// 2. 기능 클래스
class CafeSystem {

    List<CafeDto> users;

    public CafeSystem() { super(); }
    public CafeSystem(List<CafeDto> users) { super(); this.users = users; }

    // 메뉴
    public void menu() {

        int menu = -1;
        Scanner sc = new Scanner(System.in);

        while (menu != 9) {
            System.out.print(
                    "\n☕ CAFE POINT SYSTEM ☕\n"
                  + "[1] 회원등록 [2] 회원조회 [3] 포인트적립 [4] 포인트사용 [5] 회원삭제 [9] 종료\n"
                  + "👉 메뉴 선택 : "
            );
            menu = sc.nextInt();

            if (menu == 9) { exit(); break; }

            if (menu == 1) {  add();  } 
            
            else if (menu>=1 && menu<=5){
                CafeDto find = login();
                if (find == null) { System.out.println("❌ 회원정보를 확인해주세요."); continue; }
                switch (menu) {
                    case 2: show(find); break;
                    case 3: savePoint(find); break;
                    case 4: usePoint(find); break;
                    case 5: delete(find); break;
                    case 9: exit(); break;
                }
            }
            else {System.out.println("메뉴번호를 확인해주세요.");}
        }
    }

    // 회원등록
    public void add() {

        Scanner sc = new Scanner(System.in);

        System.out.print("회원명 입력 > "); String tempid = sc.next(); 
        for (CafeDto u : users) {
        	if (u.getId().equals(tempid)) {  System.out.println("중복되는 아이디입니다"); return; } }
        System.out.println("전화번호 입력 > ex)01012345678"); String temppass = sc.next();
        System.out.print("초기 포인트 입력 > "); double temppoint = sc.nextDouble();
    	
        
        users.add(new CafeDto(tempid, temppass, temppoint));

        System.out.println("✅ 회원등록 완료!");
    }

    // 로그인
    CafeDto login() {

        Scanner sc = new Scanner(System.in);

        System.out.print("회원명 입력 > ");
        String tempid = sc.next();

        System.out.println("전화번호 입력 > ex)01012345678");
        String temppass = sc.next();
        for (CafeDto u : users) {  if (u.getId().equals(tempid) && u.getPass().equals(temppass)) {  return u; } }
        return null;
    }

    // 회원조회
    void show(CafeDto user) {  
    	System.out.printf( "\n☕ 회원 정보 ☕\n" + "회원명 : %s\n" + "전화번호 : %s\n" + "보유 포인트 : %.1f점\n"
    								, user.getId(), user.getPass(), user.getPoint() ); }

    // 포인트 적립
    void savePoint(CafeDto user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("적립할 포인트 입력 > ");  double temppoint = sc.nextDouble();
        
        user.setPoint(user.getPoint() + temppoint);
        System.out.println("🎉 포인트 적립 완료!");
    }

    // 포인트 사용
    void usePoint(CafeDto user) {

        Scanner sc = new Scanner(System.in);
        System.out.print("사용할 포인트 입력 > ");  double temppoint = sc.nextDouble();

        if (user.getPoint() < temppoint) {  System.out.println("❌ 포인트가 부족합니다."); return; }
        user.setPoint(user.getPoint() - temppoint);
        System.out.println("🧋 포인트 사용 완료!");
    }

    // 회원삭제
    void delete(CafeDto user) {  
    	System.out.println( users.remove(user) ? "🗑️ 회원삭제 완료!" : "❌ 관리자에게 문의하세요." ); }

    // 종료
    void exit() {  System.out.println("👋 카페 시스템을 종료합니다."); }
}

public class CoffeeCollect {
    public static void main(String[] args) {
        List<CafeDto> users = new ArrayList<>();
        CafeSystem controller = new CafeSystem(users);

        controller.menu();
    }
}