package study10_2;

public interface PlayerLevelInterface {
	public void run();
	public void jump();
	public void turn();
	public void showLevelMessage();
	public void hack();
	public void slash();
	
	default void go(int count) {
		run();
		jump();
		for(int i=0;i<count;i++) {
			hack();
			slash();
		}
		turn();
		System.out.println();
	}
}
