package study09;

public abstract class CarAbs { //추상 클래스
	public abstract void drive(); //추상 메서드
	public abstract void stop();
	public abstract void turnOn();
	public abstract void turnOff();
	
	//템플릿 메소드
	//동작을 미리 정리
	final public void run() {
		turnOn();
		drive();
		stop();
		turnOff();
	}
	
}
