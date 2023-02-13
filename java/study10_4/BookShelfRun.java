package study10_4;

public class BookShelfRun {
	public static void main(String[] args) {
		BookShelf b = new BookShelf();
		b.enQueue("수학의 정석");
		//b.enQueue("수학의 정석2");
		b.deQueue();
		b.deQueue2();
		
		Queue q = new BookShelf();
		q.enQueue("태백산맥1");
		q.enQueue("태백산맥2");
		q.enQueue("태백산맥3");
		q.enQueue("태백산맥4");
		q.deQueue();
		//q.deQueue2();
		
		Shelf s = new BookShelf();
		//s.deQueue();
		//s.deQueue2();
		
		System.out.println(q.deQueue());
		System.out.println(q.getSize());
		System.out.println(q.deQueue());
		System.out.println(q.getSize());
		
		
	}
}
