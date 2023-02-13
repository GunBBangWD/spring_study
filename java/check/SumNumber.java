package check;

import java.util.Scanner;

public class SumNumber {
	//자릿수의 합
	//세자리수를 입력받아 각 자릿수를 더하여 결과를 출력
	//단 세자리 정수가 아닌 경우 예외처리
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		if(num<100||num>=1000) {
			System.out.println("세자리 정수가 아닙니다.");
		}else {
			int one = num%10;
			int ten = (num/10)%10;
			int hundred = num/100;
			int sum = one+ten+hundred;
			System.out.println(sum);
		}
		
//		
//		String str = input.next();
//		if(str.length()==3) {
//			int sum2 = 0;
//			String[] sarr = str.split("");
//			for(String el:sarr) {
//				sum2 += Integer.parseInt(el);
//			}
//			System.out.println(sum2);
//		}else {
//			System.out.println("세자리 정수가 아닙니다.");
//		}
	}

}
