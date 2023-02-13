package study10_2;

public class GameBoard {
	public static void main(String[] args) {
		//플레이어 객체 생성
		Player player = new Player();
		//play 한번 레벨업 반복
		player.play(1);
		player.levelUp();
		player.play(2);
		player.levelUp();
		player.play(2);
	}
}
