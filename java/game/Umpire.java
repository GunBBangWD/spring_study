package game;

import java.util.ArrayList;

class CheckNumber{
	public int countAll(ArrayList<Integer> defence, ArrayList<Integer> attack) {
		int result = 0;
		for(int i = 0; i < attack.size(); i++){
			if(defence.contains(attack.get(i))){
				result += 1;
			}
		}
		return result;
	}
	public int countStrike(ArrayList<Integer> defence, ArrayList<Integer> attack) {
		int strike=0;
        for(int i = 0; i < attack.size(); i++){
            if(defence.get(i) == attack.get(i)){
                strike += 1;
            }
        }
        return strike;
	}
}
public class Umpire {
	CheckNumber check = new CheckNumber();
	public String decide(ArrayList<Integer> defenceNumber, ArrayList<Integer> attackNumber) {
		String result="";
		int all = check.countAll(defenceNumber,attackNumber);
		int strike = check.countStrike(defenceNumber,attackNumber); 
		int ball = all-strike;
		if(all==0) {
			result="Nothing";
		}else {
			if(strike!=0){
				result+=strike+"스트라이크";
			}
			if(ball!=0) {
				result+=ball+"볼";
			}
		}
		return result;
	}
}
