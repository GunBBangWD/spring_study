package study01;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("입력:");
		int line = scan.nextInt();
		if(line%2==0) {
			System.out.println("홀수를 입력해주세요.");
		}else {
			int star=line;
			int space=0;
			for(int i=0;i<line;i++) {
				for(int j=0;j<space;j++) {
					System.out.print(" ");
				}
				for(int k=0;k<star;k++) {
					System.out.print("*");
				}
				if(i<line/2) {
					star-=2;
					space++;
				}else {
					star+=2;
					space--;
				}
				System.out.println();
			}
		}
	}

}
