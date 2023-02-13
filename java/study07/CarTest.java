package study07;

public class CarTest {
	public static void main(String[] args) {
		Car c = new Car();
		//c.carNum;//private 외부 클래스에서 접근 불가능
		int speed = c.speed; //default
		c.getSpeed(); //protected
		c.getCarNum();//public
	}
}
