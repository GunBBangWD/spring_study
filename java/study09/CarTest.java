package study09;

public class CarTest {
	public static void main(String[] args) {
		CarAbs ai = new AICar();
		CarAbs man = new ManualCar();
		ai.run();
		man.run();
	}
}
