package study09;

public class Desktop extends Computer{
	//상속받은 메서드를 임의로 재정의
	@Override
	public void display() {
		System.out.println("데스크탑 모니터");
	}
	//추상클래스의 추상메서드를 상속받은 클래스에서 반드시 재정의
	@Override
	public void typing() {
		System.out.println("데스크탑 타이핑");
	}
}
