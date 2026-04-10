package com.the703.v1;

import java.util.Scanner;

public class Bank_문대원 {

	public static void main(String[] args) {
		int a = 0; int in = 0; int out = 0; char in2='\u0000';
		int id = 0; int pass = 0; int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		
		for(;;) { 	System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "\r\n"
					+ "[1] ➕ 계좌 추가\r\n"
					+ "[2] 🔍 계좌 조회\r\n"
					+ "[3] 💵 입금하기\r\n"
					+ "[4] 💸 출금하기\r\n"
					+ "[5] 🗑️ 계좌 삭제  \r\n"
					+ "\r\n"
					+ "👉 번호를 선택하세요:");a=sc.nextInt();

			if (a==1) { //System.out.println("추가기능입니다.");
				 //입력    id = -1, pass=-1, balance;
				 System.out.print("ID   입력 > "); id=sc.nextInt();
				 System.out.print("PASS 입력 > "); pass=sc.nextInt();
				 System.out.print("금액  입력 > "); balance=sc.nextInt();
				 //             [1]ID   입력 > std11
				 //				[2]PASS 입력 > 11
				 //				[3]금액  입력 > 1b
			}
			else if (a==2 || a==3 || a==4 || a==5) {//System.out.println("조회기능입니다.");
				// 변수
					int tid = 0, tpass = 0;
				// 입력 ( 임시공간에 아이디와 비번입력받기 )
				 System.out.print("ID   입력 > "); tid=sc.nextInt();
				 System.out.print("PASS 입력 > "); tpass=sc.nextInt();
				//              [1]ID   입력 > std11
				//				[2]PASS 입력 > 11
				// 처리 + 출력
				 if (id == tid && pass == tpass && a==2) {System.out.println("ID : " + id + "\n잔액 : " + (balance));}
				
			else if (id == tid && pass == tpass && a==3) {
					System.out.print("입금 금액 입력 > ");
					in = sc.nextInt(); 
					if (in > 0) {balance += in;System.out.println(in + "원 입금 완료"+"\n잔액 : " + balance);}}

			else if (id == tid && pass == tpass && a==4) {
					System.out.println("출금 금액 입력 > ");
					out = sc.nextInt();
					if (  out > 0) {balance -= out;System.out.println(out + "원 출금 완료"+"\n잔액 : " + balance);}}
				
			else if (id == tid && pass == tpass && a==5) { 
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)");in2=sc.next().charAt(0);
					if 		(in2 == 'Y' || in2 == 'y') {System.out.println("삭제 완료");id = 0;pass = 0;}
					else if (in2 == 'N' || in2 == 'n') {System.out.println("처음으로 돌아갑니다.");}
					else {System.out.println("Y/N가 아닙니다.");}}
				 
			else {System.out.println("계정을 다시 확인해주세요");	}
			}
			
			else if (a==9) {System.out.println("종료기능입니다."); {break;}}	
			
		}
	}
}
/*
 Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
      1을 입력하면 추가기능입니다. 출력구문까지만
      2를 입력하면 조회기능입니다. 출력구문까지만
      3을 입력하면 입금기능입니다. 출력구문까지만
      4를 입력하면 출금기능입니다. 출력구문까지만
      5를 입력하면 삭제기능입니다. 출력구문까지만
      9를 입력하면 종료합니다.    출력구문까지만

Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
   ■ 힌트
   for(;;) { 
      System.out.println("숫자1을 입력하세요.");
      int a = scanner.nextInt();
      if(a == 1) { break;}
   }
   ver-1
-   조건문 : if, switch
-   반복문 : for(시작; 종료; 변화), while(조건), do while(한번은 무조건실행 맨끝에 조건)

무한반복(종료 9){
   0. 메뉴판입력
   🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n
	[1] ➕ 계좌 추가  [2] 🔍 계좌 조회  [3] 💵 입금하기\r\n  	[4] 💸 출금하기  [5] 🗑️ 계좌 삭제  [9]종료
	👉 번호를 선택하세요:
					
	1. [1] 계좌 추가
	2. [2~5]
		2-1. 사용자가 맞는지 여부
		2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제
	3. [9] 종료 }
	
while( menu!=9 ){
   0. 메뉴판입력
   🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n
	[1] ➕ 계좌 추가  [2] 🔍 계좌 조회  [3] 💵 입금하기\r\n  	[4] 💸 출금하기  [5] 🗑️ 계좌 삭제  [9]종료
	👉 번호를 선택하세요:
		
	if(menu==9){ [9] 종료문구 }
	else if(menu==1) [1] 계좌 추가
	else{ [2~5]메뉴
		2-1. 사용자가 맞는지 여부
		임시 아이디입력받기 >
		임시 비밀번호입력받기 >
		저장되어 있는 아이디와 임시 아이디가 같고 저장되어 있는 비번과 임시 비번이 같으면 아래 내용 처리
		2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제
		switch( menu ){
			case 2 : 조회처리 break;
			case 3 : 입금받기 / 잔액에 입금받은돈 추가 break;
			case 4 : 출금받기 / 잔액에 출금받은돈 빼기 (마이너스 통장 x , 잔액없으면 출금안되게) break;
			case 5 : 계좌삭제여부 , Y, y를 입력받으면 계좌삭제 / N, n는 메뉴판 돌아가기 break;
	3. [9] 종료 }
 */
