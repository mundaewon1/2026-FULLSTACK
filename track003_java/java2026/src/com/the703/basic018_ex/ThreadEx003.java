package com.the703.basic018_ex;

import java.util.Scanner;
import javax.swing.JOptionPane;

//class Count extends Thread {
//    @Override  public void run() {
//    	for(int i=10;i>0;i--) {
//    		System.out.println(i);
//    		try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
//    	}
//   /*#####1. ... 10~1까지 카운트
//   #####2. 오류시 break*/
//    }
//}

class Count extends Thread {
    @Override  public void run() {
    	for(int i=10;i>0;i--) {
    		
    		//중단요청확인
    		if( Thread.currentThread().isInterrupted() ) { break; }
    		
    		System.out.println(i);
    		try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
    	}
   /*#####1. ... 10~1까지 카운트
   #####2. 오류시 break*/
    }
}

public class ThreadEx003{
    public static void main(String[] args) {
        
    	String info = "계속카운트 합니다.";
    	Thread count = new Count();  count.start();
        
        String answer = JOptionPane.showInputDialog("count stop?  y/n");
		if(answer.toLowerCase().equals("y")) { count.interrupt(); info = "count를 멈춥니다."; }
        //##### 3. 입력받기
        //if(만약에 정답이라면){대상.interrupt();}
		
		System.out.println(info);
        System.out.println("> main end....");
    }
}