package game;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {
	//랜덤 숫자 생성
	public int randomNumberMake() {
		int result;
//		result = (int)(Math.random()*9+1); // Math.random 사용 
		Random random = new Random(); //Random class 사용
		result = random.nextInt(9)+1; // random.nextInt(max) + min;
		return result;
	}
	
	public ArrayList<Integer> Generate(int level) {
		ArrayList<Integer> defenceNumber = new ArrayList<>();
		while(defenceNumber.size()<level) {
			int randomNumber = randomNumberMake();
			if(defenceNumber.contains(randomNumber)) {
				continue;
			}else {
				defenceNumber.add(randomNumber);
			}
		}
		return defenceNumber;
	}
}
