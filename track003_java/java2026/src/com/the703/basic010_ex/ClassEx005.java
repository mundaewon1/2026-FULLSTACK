package com.the703.basic010_ex;

class Card{
	   int cardNum;
	   boolean  isMembership;   
	   
	   public Card() { super(); }
	   public Card(int cardNum, boolean isMembership) { super(); this.cardNum = cardNum; this.isMembership = isMembership; }
	   @Override public String toString() { return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]"; }
	   //행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
	   void input() {}
	   void show() {}
	}

public class ClassEx005 {
	public static void main(String[] args) {
		 Card  c1= new Card(); 
		   System.out.println(c1);
	}
}
//출력내용 : Card[cardNum=0, isMembership=false]