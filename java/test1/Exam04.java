package test1;

public class Exam04 {
	public static void main(String[] args) {
		System.out.println(Math.random());
		//2개의 주사위를 던졌을 때 눈의 합의 값이 5이면 코드 정지
		//12가 나오면 감탄사
		//나오는 값을 출력
		while(true) {
			int i = (int)(Math.random()*6)+1; 
			int j = (int)(Math.random()*6)+1;
			
			System.out.println("DICE GAME");
			System.out.printf("rolling...[%d,%d]\n",i,j);
			
			int sum = i+j;
			if(sum == 5) {
				System.out.println("탈출");
				break;
			}
			if(sum == 12) {
				System.out.println("나이스");
			}
			
			
			
			
			
			
			
			for(double k=0;k<=99999999;k++) {
				double sum2 =0;
				sum *= k;
			}
			
		}
		
	}
}
