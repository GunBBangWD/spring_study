package study10;

public interface Calc {
	//상수
	final double PI = 3.14;
	final int ERROR = -9999;
	//추상메서드
	int add(int num1,int num2);
	int sub(int num1,int num2);
	int times(int num1,int num2);
	double div(int num1,int num2);
	//디폴트 메서드 : 공통적 구현해야 하는 메서드 
	default void desc() {
		privateMethod();
		privateStaticMethod();
		System.out.println("계산기 구현");
	}
	//정적 메서드
	static int total(int[] arr) {
		int total=0;
		for(int i:arr) {
			total += i;
		}
		//privateMethod();
		privateStaticMethod();
		return total;
	}
	//private 메서드
	private void privateMethod() {
		System.out.println("private Method");
	}
	private static void privateStaticMethod() {
		System.out.println("Private static method");
	}
}
