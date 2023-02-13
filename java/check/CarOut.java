package check;

import study07.Car;

public class CarOut {
	public void carMethod() {
		Car c = new Car();
		//c.carNum;//private
		//int speed = c.speed; //default
		//c.getSpeed(); //protected
		c.getCarNum();//public
	}
}
