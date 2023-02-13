package test1;

import java.util.ArrayList;
import java.util.Arrays;

public class Exam07 {
	public static void main(String[] args) {
		//1.변수
		int korean = 80;
		String english = "75";
		double math = 53;
		System.out.printf("평균:%.2f\n",
				(korean+Integer.parseInt(english)+math)/3);
		//2.짝수 홀수 구분
		int[] source = {9,12,14,21,16,13};
		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();
		for(int s: source) {
			if(s%2==0) {
				even.add(s);
			}else {
				odd.add(s);
			}
		}
		System.out.println(even);
		System.out.println(odd);
		//5.역순정렬(선택정렬) -> Arrays.sort()
		for(int i=0;i<source.length;i++) {
			for(int j=i+1;j<source.length;j++) {
				if(source[i]<source[j]) {
					int temp=source[i];
					source[i]=source[j];
					source[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(source));
		//3.주민번호 - > 생년월일 성별
		String socialNumber = "871130-1463217";
		String[] sNums = socialNumber.split("-");
		int code = Integer.parseInt(sNums[1].substring(0,1));
		String birthDate = null;
		String gender = null;
		if(code==1 || code==2) {
			birthDate = "19"+sNums[0].substring(0,2);
			gender = code==1?"남자":"여자";
		}else if(code==3 || code==4) {
			birthDate = "20"+sNums[0].substring(0,2);
			gender = code==3?"남자":"여자";
		}
		System.out.println(birthDate+"년"
				+sNums[0].substring(2,4)+"월"
				+sNums[0].substring(4, 6)+"일"
				+"| 성별:"+gender);
		//4.문자열 치환
		String a="a:b:c:d";
		System.out.println(a.replaceAll(":", "#"));
		
		
		
		
		
		
		
	}
}
