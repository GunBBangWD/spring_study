package study01;

public class Conditional {

	public static void main(String[] args) {
		int age = 13;
		int charge = 0;
		
		if(age<1) {
			charge=0;
			System.out.println("영유아");
		}else if(age<14) {
			charge=1500;
			System.out.println("초등학생");
		}else if(age<20) {
			charge=2500;
			System.out.println("중고등학생");
		}else{
			charge= 3000;
			System.out.println("성인");
		}
		System.out.println("교통비:"+charge+"원");
		
		int rank =1;
		String medalColor;
		
		switch (rank) {
			case 1:
				medalColor="금메달";
				break;
			case 2:
				medalColor="은메달";
				break;
			case 3:
				medalColor="동메달";
				break;
			default:
				medalColor="없음";
		}
		System.out.println(rank+"등 메달:"+medalColor);
	}
}
