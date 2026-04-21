package com.the703.basic010_ex;

class Score{
	   String stdid;
	   int kor,eng,math,total; double avg;  
	   
	public Score() { super(); }
	public Score(String stdid, int kor, int eng, int math) { super(); this.stdid = stdid; this.kor = kor; this.eng = eng; this.math = math; this.total = total; this.avg = avg; }
	@Override public String toString() { return "Score [stdid=" + stdid + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total + ", avg=" + avg + "]"; }
	   // 총점구해주기
	void total() {total=kor+eng+math;}
	   // 평균구하기              
	void avg() {avg=total/3.0;}
	   // 학생정보출력                     
	void info() {
		total(); avg();
		System.out.printf("학번\tkor\teng\tmath\ttotal\tavg\r\n"
				+ "%s\t%d\t%d\t%d\t%d\t%.2f",stdid,kor,eng,math,total,avg);
	}
	   // ※힌트2)  info(){    total();  avg();     }  다른메서드에서 메서드 사용가능  
	   //※ 힌트1) 생성자 :   Score() / Score(stdid, kor, eng, math)
	}

public class ClassEx006 {
	public static void main(String[] args) {
		   Score  s1= new Score("std1234" , 100, 100 , 99 ); 
		   
		   s1.info();
	}
}
