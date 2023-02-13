package game;

import java.util.ArrayList;

import study01.Sysout;

public class BaseballGameMain {
	public static void main(String[] args) {
		//필요한 객체 일괄 생성
		RandomNumber randomNum = new RandomNumber();
		InputNumber input = new InputNumber();
		Umpire umpire = new Umpire();
		RestartGame restartGame = new RestartGame();
		
		
		boolean restart = true; //게임 재시작 여부
		//반복1- 게임 재시작
		System.out.println("<>===== BASEBALL GAME =====<>");
		while(restart) {
			//게임 레벨 설정(숫자의 갯수)
			int level = input.getLevel();
			System.out.println(">>>> PLAY BALL!!! <<<<");
			//랜덤 숫자 생성
			ArrayList<Integer> defenceNumber = randomNum.Generate(level);
			System.out.println(defenceNumber);
			//반복2 - 숫자 정답 전까지 반복(10회 제한) 제한이 없다면 while(true) 반드시 탈출조건
			//레벨별 반복횟수 차이 3-10 4-15 5-20
			for(int i=5*(level-1)-1;i>=0;i--) {
				//입력
				ArrayList<Integer> attackNumber = input.generatePlayerNumber(level);
				System.out.println(attackNumber);
				//결과 판정
				String result = umpire.decide(defenceNumber,attackNumber);
				//출력
				System.out.println(result);
				if(result.equals(level+"스트라이크")) break;
				System.out.printf("남은 기회: %d회\n",i);
				if(i==0) {
					System.out.println("경기종료");
					break;
				}
			}
			//경기 재시작
			restart = restartGame.askOp();
		}
	}
}
