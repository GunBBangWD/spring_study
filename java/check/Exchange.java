package check;

import java.util.Scanner;

public class Exchange {
	public static void main(String[] args) {
		// 유로 달러 두번 입력
		// 한화로 얼마인지 
		// 환율 검색 1유로=1336.42 1불=1228.92
		 Scanner input = new Scanner(System.in);
		 int euro =input.nextInt();
		 int dollar =input.nextInt();
		 input.close();
		 //환율 변수
		 double euroRate = 1336.42;
		 double dollarRate = 1228.92;
		 //환전
		 int won =(int)(euro*euroRate + dollar*dollarRate);
		 System.out.println(won);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
}
