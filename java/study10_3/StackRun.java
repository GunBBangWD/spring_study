package study10_3;

import java.util.Scanner;

public class StackRun {
	public static void main(String[] args) {
		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int max = inputInt.nextInt();
		StringStack s1 = new StringStack(max);
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			String str = inputString.nextLine();
			if(str.equals("그만"))
				break;
			boolean choice = s1.push(str);
			if(choice == false) {
				System.out.println("스택이 가득 참");
			}
		}
		System.out.print("스택이 저장된 모든 문자열 팝 : ");
		int len = s1.length();
		for(int i = 0; i < len; i++)
			System.out.print(s1.pop() + " ");
		inputInt.close();
		inputString.close();
	}
}
