package study10_2;

public class Player {
	private PlayerLevelInterface level;
	
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	public PlayerLevelInterface getLevel() {
		return level;
	}
	public void levelUp() {
		if(level instanceof BeginnerLevel) {
			level = new AdvancedLevel();
		}else if(level instanceof AdvancedLevel) {
			level = new SuperLevel();
		}
		level.showLevelMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
}
