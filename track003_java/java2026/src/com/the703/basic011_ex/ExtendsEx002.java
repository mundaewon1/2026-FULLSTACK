package com.the703.basic011_ex;

class MobileNote {
	void show() {}
}
class MobileNote7 extends MobileNote {
	private String iris;
	private String face;
	void newShow() {
		System.out.println("NOTE7 객체 기능(Overriding)\r\n" + "iris = "+this.iris+"n\r\n" + "face = "+this.face);  }
	
	//// 생성자 오버로딩 (이름이 같음 - 파라미터의 자료형과 갯수)
	public MobileNote7() { super(); }
	public MobileNote7(String iris, String face) { super(); this.iris = iris; this.face = face; }

	public String getIris() { return iris; } public void setIris(String iris) { this.iris = iris; }
	public String getFace() { return face; } public void setFace(String face) { this.face = face; }
}

class MobileNote8 extends MobileNote7 {
	private String face;
	///// 오버라이딩 ( 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의 )
	@Override void newShow() {super.newShow();
		System.out.println("NOTE8 객체 기능(Overriding) 추가\r\n" + "face = "+this.face);  }

	public String getFace() { return face; } public void setFace(String face) { this.face = face; }
}

class MobileNote9 extends MobileNote8 {
	private int battery;
	public MobileNote9(String iris, String face, int battery) {
		this.setIris(iris); this.setFace(face); this.battery = battery;
	}
	@Override void newShow() {super.newShow();
		System.out.println("NOTE9 객체 기능(Overriding) 추가\r\n" + "battery 예쁘게 사용하기!\r\n" + "battery = "+this.battery);  }
	
	public int getBattery() { return battery; } public void setBattery(int battery) { this.battery = battery; }
}
		
public class ExtendsEx002{
    public static void main(String[] args) {
//        MobileNote7 my7 = new MobileNote7();
//        my7.setIris("brown");
//        my7.setFace("pretty");
//        my7.newShow();
//
//        MobileNote8 my8 = new MobileNote8();
//        my8.setFace("pretty");
//        my8.newShow();
//
//        MobileNote9 my9 = new MobileNote9();
//        my9.setBattery(24);
//        my9.newShow();
    	
    	MobileNote9 my9 = new MobileNote9("brown", "pretty", 24*7);
    	my9.newShow();
    }
}