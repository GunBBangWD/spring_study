package study01;

import java.time.LocalDate;

public class ConditionalPrac {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		String dayOfWeek = now.getDayOfWeek().toString();
		int dayOfWeekValue = now.getDayOfWeek().getValue();
		System.out.println(dayOfWeek+" "+dayOfWeekValue);
		
		String result = "";
		if(dayOfWeekValue==5) {
			result="불금";
		}else if(dayOfWeekValue==6 || dayOfWeekValue==7) {
			result="주말";
		}else {
			result="주말 아니고 평일--;";
		}
		System.out.println(result);
		
		switch(dayOfWeekValue) {
		case 5:
			result="불금";
			break;
		case 6: case 7:
			result="주말";
			break;
		default:
			result = "평일";
		}
		System.out.println(result);
	}

}
