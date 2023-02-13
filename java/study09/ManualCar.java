package study09;

public class ManualCar extends CarAbs {
	@Override
	public void drive() {
		System.out.println("사람이 운전");
	}
	@Override
	public void stop() {
		System.out.println("사람이 브레이크를 사용");
	}
	@Override
	public void turnOn() {
		System.out.println("키로 시동켜기");
	}
	@Override
	public void turnOff() {
		System.out.println("키로 시동끄기");
	}

}
