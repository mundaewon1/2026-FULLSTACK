package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1 {

	public static void main(String[] args) {
		int a = -1; int in = 0;
		int id = -1; int pass = -1; int balance = -1;
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

				 if (a==1) {System.out.println("추가기능입니다.");
				 //입력    id = -1, pass=-1, balance;
				 System.out.print("ID   입력 > "); id=sc.nextInt();
				 System.out.print("PASS 입력 > "); pass=sc.nextInt();
				 System.out.print("금액  입력 > "); balance=sc.nextInt();
				 //             [1]ID   입력 > std11
				 //				[2]PASS 입력 > 11
				 //				[3]금액  입력 > 1b
				 }
			else if (a==2) {System.out.println("조회기능입니다.");
				// 변수
				int tid=-1, tpass=-1;
				// 입력 ( 임시공간에 아이디와 비번입력받기 )
				 System.out.print("ID   입력 > "); tid=sc.nextInt();
				 System.out.print("PASS 입력 > "); tpass=sc.nextInt();
				//              [1]ID   입력 > std11
				//				[2]PASS 입력 > 11
				// 처리 + 출력
				 if(id==tid && pass==tpass) {System.out.println("잔액 : "+balance);}
				 else                       {System.out.println("비밀번호를 확인해주세요!");}
				//   9번째 줄에 있는 아이디와 임시아이디가 같고, 9번째 줄에 있는 비번과 임시 비번이 같으면 정보출력
				//   아니라면 비밀번호를 확인해주세요!
			}
			else if (a==3) {System.out.println("입금기능입니다.");
			 	System.out.print("ID   입력 > "); id=sc.nextInt();
			    System.out.print("PASS 입력 > "); pass=sc.nextInt();
			 	System.out.print("입금 금액  > "); in=sc.nextInt();
			 	if(in>0) {System.out.println("입금 완료");
			 			  System.out.println("통장잔고 : "+(balance+in));}
			 	else     {System.out.println("다시 확인해주세요");}
			}
			else if (a==4) {System.out.println("출금기능입니다.");}
				 
			else if (a==5) {System.out.println("삭제기능입니다.");}
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
 */
