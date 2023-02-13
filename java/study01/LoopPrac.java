package study01;

public class LoopPrac {

	public static void main(String[] args) {
		int line =4;
		
		for(int i=0;i<line;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(int i=0;i<line;i++) {
			for(int j=0;j<line-i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		int space = line-1;
		int star = 1;		
		for(int i=0;i<line;i++) {
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<star;k++) {
				System.out.print("*");
			}
			space--;
			star++;
			System.out.println("");
		}
		
		for(int i=1;i<=line;i++) {
			for(int j=line-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int k=0;k<i;k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		space = 0;
		star = line;		
		for(int i=0;i<line;i++) {
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<star;k++) {
				System.out.print("*");
			}
			space++;
			star--;
			System.out.println("");
		}
		
		space = line-1;
		star = 1;		
		for(int i=0;i<line;i++) {
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<star;k++) {
				System.out.print("*");
			}
			space--;
			star+=2;
			System.out.println("");
		}
		
		line=7;
		star=1;
		System.out.println(line/2);
		for(int i=0;i<line;i++) {
			for(int k=0;k<star;k++) {
				System.out.print("*");
			}
			if(i<line/2) {
				star++;
			}else {
				star--;
			}
			System.out.println("");
		}
		
		line=7;
		star=1;
		space = line/2;
		for(int i=0;i<line;i++) {
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<star;k++) {
				System.out.print("*");
			}
			if(i<line/2) {
				space--;
				star+=2;
			}else {
				space++;
				star-=2;
			}
			System.out.println("");
		}
		
	}

}
