package study03;

public class Recursive {
	//재귀함수
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
		System.out.println(factorial(3));
	}
	//피보나치 수열
	public static long fibonacci(long n){
		if(n<=2) {
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	//팩토리얼
	public static long factorial(long n) {
		if(n<=1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
}
