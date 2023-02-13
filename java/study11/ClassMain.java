package study11;

abstract class AbstractClass{
	int a=10,b=20;
	abstract int sum(int a);
}
class NormalClass{
	int a=10,b=20;
	int sum(int c) {
		return a+b+c;
	}
}
public class ClassMain {
	public static void main(String[] args) {
		NormalClass nor = new NormalClass();
		System.out.println(nor.sum(10));
		
		AbstractClass abs = new AbstractClass() {
			int c=30;
			@Override
			int sum(int a) {
				return this.a+b+a+c;
			}
		};
		System.out.println(abs.sum(15));
		
		NormalClass nor2 = new NormalClass() {
			int d = 40;
			int sum(int c) {
				return a+b+c+d;
			}
		};
		System.out.println(nor2.sum(40));
		
		System.out.println(new NormalClass().sum(10));
		
		System.out.println(new NormalClass() {
			int d = 40;
			int sum(int c) {
				return a+b+c+d;
			}
		}.sum(100));
		
		
		
	}
}
