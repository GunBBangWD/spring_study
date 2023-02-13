package study02_1;

import study02.Car;

public class CarTest {

	public static void main(String[] args) {
		Car c = new Car();
		//c.carNum; //private 접근 불가 
		//int speed = c.speed; //default 외부 패키지 사용불가
		//c.getSpeed(); //protected 외부 패키지 사용불가
		c.getCarNum(); //public		
	}

}
