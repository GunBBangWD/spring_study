package study07;

public class Bus extends Car {
	public static void main(String[] args) {
		Bus b = new Bus();
		//b.carNum; //private
		int speed = b.speed; //default
		b.getSpeed();//protected
		b.getCarNum();//public
	}
}
