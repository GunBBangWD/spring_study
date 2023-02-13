package study02;

public class CarTest {
	public static void main(String[] args) {
		Car c = new Car();
		//c.carNum; //private 접근 불가 
		int speed = c.speed; //default
		c.getSpeed(); //protected
		c.getCarNum(); //public		
	}

}
