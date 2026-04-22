package com.the703.basic010_ex;
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------------------
[METHOD:정보]	 LunchTray.class	MemberVarEx003.class #1
	LunchTray.trayCount = 0;	LunchTray.maxRice = 100;  
	LunchTray.showTrayCount()	LunchTray.showOwner()
------------------------------------------------------------------------
[HEAP:동적]           						 			|  [STACK:지역]
2번지:{owner="std-"+ ++trayCount, rice=90, soup=85}		<-	tray2[2번지]
1번지:{owner="std-"+ ++trayCount, rice=90, soup=85}		<-	tray1[1번지]
												 		 	main #2
------------------------------------------------------------------------
*/
//////////////////////////////////////////////////////
class LunchTray {
	String owner="std-"+ ++trayCount;     //	인스턴스변수
    
    int rice = 90;       //	인스턴스변수      
    int soup = 85;       //	인스턴스변수  

    static int trayCount = 0;  // 클래스변수

    //static int totalFood = rice + soup; // 클래스변수에 인스턴스변수 사용불가

    static int maxRice = 100;    // 클래스변수  

    public int getFoodAmount() { // 인스턴스메서드
        return rice + soup;         
    }

    public static void showTrayCount() { // 클래스메서드
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public static void showOwner() { // 클래스메서드
     //  System.out.println(owner); // 인스턴스변수 사용불가
    }

    public void showTray() { // 인스턴스메서드
        System.out.println("\n\n:: 주인 이름: " + owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}


public class MemberVarEx003 {
   public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         
   }
} 