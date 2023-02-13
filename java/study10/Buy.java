package study10;

public interface Buy {
	void buy();
	default void order() {
		System.out.println("주문완료");
	}
}
