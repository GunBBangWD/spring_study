package study09;

public class AICar extends CarAbs {
	@Override
	public void drive() {
		System.out.println("자율주행");
	}
	@Override
	public void stop() {
		System.out.println("자동멈춤");
	}
	@Override
	public void turnOn() {
		System.out.println("시동켜고 목적지 입력");
	}
	@Override
	public void turnOff() {
		System.out.println("목적지 도착 후 시동 끄기");
	}
}
