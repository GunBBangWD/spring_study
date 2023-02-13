package study07;
//Bus CarTest CarOut Taxi
public class Car {
	private int carNum = 1000;
	
	int speed = 100;
	
	protected void getSpeed() {
		System.out.println(speed);
	}
	
	public void getCarNum() {
		System.out.println(carNum);
	}
}
