package study01;

public class Loop {

	public static void main(String[] args) {
		int num = 1; //초기화
		int sum = 0; //합계
		while(num <= 10) { //조건식
			sum += num;
			num++; //증감식
		}
		System.out.println("합계:"+sum);
		
		num = 1; //초기화
		sum = 0; //합계
		do {
			sum += num;
			num++; //증감식
		}while(num <= 10); //조건식
		System.out.println("합계:"+sum);
		
		sum=0;
		for(int i=1;i<=10;i++) {
			sum += i;
		}
		System.out.println("합계:"+sum);
		
		//구구단
		for(int dan=2;dan<=9;dan++) {
			for(int t=1;t<=9;t++) {
				System.out.println(dan+"X"+t+"="+(dan*t));
			}
			System.out.println();
		}
		
		int dan=2;
		while(dan<=9) {
			int t=1;
			while(t<=9) {
				System.out.println(dan+"X"+t+"="+(dan*t));
				t++;
			}
			System.out.println();
			dan++;
		}
		
		for(int i=0;i<10;i++) {
			if(i==4) {
				break;
			}
			System.out.println(i);
		}
		for(int i=0;i<10;i++) {
			if(i==4) {
				continue;
			}
			System.out.println(i);
		}
		//1~100까지 합계
		int total = 0;
		for(int i=1;i<=100;i++) {
			total += i;
		}
		System.out.println("합계 : "+total);
		//1-100까지 짝수만 합계
		total = 0;
		for(int i=1;i<=100;i++) {
			if(i%2==1) {
				continue;
			}
			total += i;
		}
		System.out.println("합계 : "+total);
		
		total=0;
		for(int i=2;i<=100;i+=2) {
			total += i;
		}
		System.out.println("합계 : "+total);
		
		int sum1 = 0;
		int num1 = 1;
		while(num1<=100) {
			sum1 += num1;
			if(sum1>100) {
				break;
			}
			num1++;
		}
		System.out.println(sum1+" "+num1);
		
		int sum2 = 0;
		int num2 = 1;
		for(num2= 1;num2<=100;num2++) {
			sum2 += num2;
			if(sum2>100) {
				break;
			}
		}
		System.out.println(sum2+" "+num2);
		
		for(dan=1; dan<=9;dan++) {
			System.out.println(dan);
			for(int t=1;t<=9;t++) {
				if(dan==5) {
					System.out.println(">>>>>>>>>>>>");
					break;
				}
				System.out.println(dan+"X"+t+"="+dan*t);
			}
			System.out.println();
		}
		
		out:
		for(dan=2; dan<=9;dan++) {
			for(int t=1;t<=9;t++) {
				if(dan==5)continue out;
				System.out.print(dan+"X"+t+"="+dan*t+" ");
			}
			System.out.println();
		}
		
	}

}
