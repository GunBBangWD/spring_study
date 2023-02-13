package study03;

public class ArrayRun {
	public static void main(String[] args) {
		Subject[] sub = new Subject[10];
		int[] num1 = new int[10];
		int[] num2 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(num1.length);
		System.out.println(num2.length);
		System.out.println(num2[3]+" "+num1[3]);
		num1[1]=11;
		System.out.println(num1[1]+" "+num1[0]);
		
		for(int i=0;i<num1.length;i++) {
			System.out.print(num1[i]+" ");
		}
		System.out.println();
		
		for(int i=0;i<num2.length;i++) {
			System.out.print(num2[i]+" ");
		}
		System.out.println();
		for(int k:num2) {
			System.out.print(k+" ");
		}
		System.out.println();
		
		String[] str = new String[5];
		System.out.println(str[2]);
		boolean[] bool = new boolean[5];
		System.out.println(bool[3]);
		double[] dd = new double[5];
		System.out.println(dd[3]);
		
		char[] alphabet = new char[26];
		System.out.println(alphabet[3]);
		
		char ch = 'A';//65
		ch = 66;
		int k = 'A';
		System.out.println(ch+" "+k);
		ch = 'A';
		for(int i=0;i<alphabet.length;i++,ch++) {
			alphabet[i]=ch;
		}
		for(int i=0;i<alphabet.length;i++) {
			System.out.print(alphabet[i]);
		}
		System.out.println();
		for(char c:alphabet) {
			System.out.print(c);
		}
		
		
		
		
		
		
		
		
		
		
	}
}
