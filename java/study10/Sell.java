package study10;

public interface Sell {
	void sell();
	default void order() {
		System.out.println("판매완료");
	}
}
