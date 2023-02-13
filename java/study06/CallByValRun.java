package study06;

class Uper{
	void uper(int c) {
		c++;
	}
	void uper(Counter counter) {
		counter.count++;
	}
}
class Counter{
	int count=0; //객체변수 클래스변수 멤버변수
}
public class CallByValRun {
	public static void main(String[] args) {
		Counter mc = new Counter();
		System.out.println(mc.count);
		Uper up = new Uper();
		//up.uper(mc.count);
		up.uper(mc);
		System.out.println(mc.count);
	}
}
