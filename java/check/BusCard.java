package check;

import java.util.Scanner;

public class BusCard {
	/*
		성인: 만 18세 이상
		청소년: 만 13세 이상
		어린이: 만 6세 이상
		유아: 만 5세 이하
	 */
	public static String getRole(int age) {
		String role="";
        if(age>=18 ) {
        	role="성인";
        }else if(age<18 && age>=13 ) {
        	role="청소년";
        }else if(age>=6 ) {
        	role="어린이";
        }else{
        	role="유아";
        }
		return role;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		String role = getRole(age);
		System.out.println(role);
	}

}
