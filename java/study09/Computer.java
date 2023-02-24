package study09;

public abstract class Computer {
	Computer() {
		System.out.println("computer");
	}
	public void display() {};
	//public void study20.test(); //실행문 or abstract
	public abstract void typing(); //추상메서드
	
	public void trunOn() {
		System.out.println("전원켜기");
	}
	public void trunOff() {
		System.out.println("전원끄기");
	}

}
