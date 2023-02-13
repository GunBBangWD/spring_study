package game;

import java.util.ArrayList;
import java.util.Scanner;

public class InputNumber {
	Scanner scanner = new Scanner(System.in);

	public ArrayList<Integer> generatePlayerNumber(int level) {
        ArrayList<Integer> attackNum = new ArrayList<>();
        String input;
        while(true) {
        	System.out.println(level+"자리 숫자를 입력해주세요.");
        	input = scanner.next();
        	//if(input.length()!=level) {
        	if(!input.matches("\\d{"+level+"}") || duplicateInputCheck(input)) {
        		System.out.println("올바른 입력이 아닙니다.");
        		continue;
        	}
        	break;
        }
        for(String number: input.split("")){
            attackNum.add(Integer.parseInt(number));
        }
        return attackNum;
	}

	public int getLevel() {
		System.out.println("레벨을 선택하세요.");
		System.out.printf("1: 초보  2: 숙련  3: 달인\n입력:");
		String input;
		while(true) {
			input = scanner.next();
			if(!input.matches("[1-3]{1}")) {
				System.out.print("레벨을 선택하세요. 입력:");
				continue;
			}
			break;
		}
		return Integer.parseInt(input)+2;
	}
	
	public boolean duplicateInputCheck(String input) {
		for(int i=0;i<input.length();i++) {
			if(input.substring(i+1).contains(input.substring(i,i+1))) {
				System.out.println("중복숫자가 있습니다.");
				return true;
			}
		}
		return false;
	}
	
}
