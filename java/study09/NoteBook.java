package study09;

public abstract class NoteBook extends Computer {
	//추상메서드를 구현하지 않으면 추상클래스가 된다.
	@Override
	public void display() {
		System.out.println("노트북 모니터");
	}
}
