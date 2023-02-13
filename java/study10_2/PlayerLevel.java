package study10_2;

public abstract class PlayerLevel {
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	public abstract void hack();
	public abstract void slash();
	
	public final void go(int count) {
		run();
		jump();
		for(int i=0;i<count;i++) {
			hack();
			slash();
			System.out.println();
		}
		turn();
	}
}
