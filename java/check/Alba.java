package check;

import java.util.Scanner;

public class Alba {
	//급여계산
	//시급, 일한 시간을 입력
	/*
	 Scanner input = new Scanner(System.in);
	 int ? =input.nextInt(); 
	 */
	//최종적으로 급여를 출력
	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 int payPerHour =input.nextInt();
		 int workingHour =input.nextInt();
		 input.close();
		 int pay = payPerHour*workingHour;
		 System.out.println(pay);
	}

}
