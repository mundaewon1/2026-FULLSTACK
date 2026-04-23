package com.the703.basic010_ex;
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------------------
[METHOD:정보] Student.class	MemberVarEx002.class #1
	Student.studentCount = 0;	Student.maxScore = 100;
	Student.showStudentCount()	Student.showName()
------------------------------------------------------------------------
[HEAP:동적]           				 |  [STACK:지역]
2번지:{name="홍길동", kor=90, eng=85}	<-	 s2[2번지]
1번지:{name="홍길동", kor=90, eng=85}	<-	 s1[1번지]
									 	 main #2
------------------------------------------------------------------------
*/
//////////////////////////////////////////////////////
class Student {
	
    String name = "홍길동";  	 // 인스턴스변수     
    int kor = 90;       	 // 인스턴스변수             
    int eng = 85;            // 인스턴스변수    
    static int studentCount = 0;    // 클래스변수
    //static int total = kor + eng;   // 클래스변수(method) - 인스턴스변수(heap) 구동시작점 달라서 사용불가
    static int maxScore = 100;     // 클래스변수

    public Student() { // 인스턴스메서드
        studentCount++;             
    }

    public int getTotalScore() { // 인스턴스메서드
        return kor + eng;        
    }

    public static void showStudentCount() { // 클래스메서드
        System.out.println("전체 학생 수: " + studentCount);  
    }

   public static void showName() {	// 클래스메서드
   //      System.out.println(name);  // 인스턴스변수 사용불가
   }

    public void showInfo() { // 인스턴스메서드
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}

public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}
