package study02;

public class Car {
	private int carNum=1000;
	
	int speed=100;
	
	protected int speed2=120;
	
	protected void getSpeed() {
		System.out.println(speed);
	}
	
	public void getCarNum() {
		System.out.println(carNum);
	}
}
