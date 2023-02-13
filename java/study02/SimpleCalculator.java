package study02;

class Calculator{
	//생성자 객체 생성
	//Calculator(){};
	//필드 속성
	private int result=0;
	static int memory = 3;
	//메소드 기능
	int add(int num) {
		result += num;
		return result;
	}
}

public class SimpleCalculator {

	public static void main(String[] args) {
		Calculator cal1 = new Calculator();
		System.out.println(cal1);
		Calculator cal2 = new Calculator();
		System.out.println(cal2);
		
		System.out.println( cal1.add(5) );
		//cal1.result = 11; 임의 값 변경이 불가능하도록 정보은닉
		System.out.println( cal1.add(4) );
		//System.out.println( cal1.result );
		//System.out.println( cal2.result );
		
		System.out.println( cal1.memory );
		System.out.println( cal2.memory );
		cal1.memory=10;
		System.out.println( cal1.memory );
		System.out.println( cal2.memory );


	}

}
