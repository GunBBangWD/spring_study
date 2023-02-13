package game;

import java.util.Scanner;

public class RestartGame {

	public boolean askOp() {
        System.out.println("정답! 경기를 다시 하시겠습니까? 다시 시작 : 1, 종료 : 2");
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        if(answer == '1'){
            return true;
        }else {
        	System.out.println("Game Over");
        	return false;
        }
	}

}
