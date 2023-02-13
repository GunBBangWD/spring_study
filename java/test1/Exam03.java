package test1;

public class Exam03 {
	public static void main(String[] args) {
		//A class에 10명의 학생이 성적이 아래와 같다면 평균값은 ?
		int[] scores = {70,60,55,75,95,90,79,80,85,100};
		int sum1=0, sum2=0;
		double mean1=0,mean2=0;
		//for
		for(int i=0;i<scores.length;i++) {
			sum1 += scores[i];
		}
		mean1 = (double)sum1/scores.length;
		System.out.printf("평균 : %f",mean1);
		//향상된 for
		for(int el:scores) {
			sum2 += el;
		}
		mean2 = (double)sum2/scores.length;
		System.out.printf("평균 : %.2f",mean1);
		
		
		
		
		
		
		
		
	}
}
