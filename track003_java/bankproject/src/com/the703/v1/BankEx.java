package com.the703.v1;

import java.util.Scanner;

public class BankEx {

	public static void main(String[] args) {
		//변수
		int menu = -1;
		int id   = -1, pass = -1, balance = -1, tempbalance=-1;
		Scanner sc = new Scanner(System.in);
		
		//입력 //처리 //출력
		//for(  ; menu!=9; ) {
		while( menu!=9 ) {
			System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분 정보
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "\r\n"
					+ "[1] ➕ 계좌 추가\r\n"
					+ "[2] 🔍 계좌 조회\r\n"
					+ "[3] 💵 입금하기\r\n"
					+ "[4] 💸 출금하기\r\n"
					+ "[5] 🗑️ 계좌 삭제  \r\n"
					+ "\r\n"
					+ "👉 번호를 선택하세요:");menu=sc.nextInt();
					
			if(menu == 9) {
			System.out.println("프로그램을 종료합니다."); 
			} else if(menu == 1) {
				//변수 x
				//입력
			System.out.print("아이디   입력 > "); id=sc.nextInt();
			System.out.print("비밀번호 입력 > "); pass=sc.nextInt();
			System.out.print("잔액    입력 > "); balance=sc.nextInt();
			
				//처리 x 출력 x
			} else if(menu>=2 && menu<=5) {		
			//	2-1. 사용자가 맞는지 여부
			int tempid=-1, temppass=-1;
			System.out.print("아이디   입력 > "); tempid=sc.nextInt();
			System.out.print("비밀번호 입력 > "); temppass=sc.nextInt();
			//( !( id == tempid && pass == tempass) ) { continue;}
			if( id != tempid || pass != temppass) { System.out.println("정보확인해주세요."); continue;} // 아이디가 다르거나 비번이 다르다면 continue
			
			//	저장되어 있는 아이디와 임시 아이디가 같고 저장되어 있는 비번과 임시 비번이 같으면 아래 내용 처리
			switch( menu ) {
				case 2 : System.out.printf("ID : %d\nPASS: %d\nBALANCE: %d\n", id, pass,balance); 	  break;
				case 3 : System.out.print("입금할 금액 > "); balance += sc.nextInt(); 	 		 		  break;
				case 4 : 
					System.out.print("출금할 금액 > "); tempbalance = sc.nextInt();    			
					System.out.println( tempbalance > balance ?"잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (balance -= tempbalance));
				break;
				case 5 : System.out.println("계좌삭제 (Y/N) > "); char again = sc.next().charAt(0);
					if(again == 'Y' || again == 'y') {id   = -1; pass = -1; balance = -1;}
				break;
				}
			}
		}// end while

	}

}
