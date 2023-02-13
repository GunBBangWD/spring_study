package study01;

public class Variable {
	public static void main(String[] args) {
		//변수 선언
		int num = 10;
		System.out.println(num);
		//진수 표현
		int binNum = 0B1010;
		System.out.println(binNum);
		int octNum = 013;
		System.out.println(octNum);
		int hexNum = 0x1A;
		System.out.println(hexNum);
		//String binary = Integer.toBinaryString(num);
		//System.out.println("2진수:"+binary);
		
		//integer 32bit
		int num1 = 0B00000000000000000000000000000101;//5
		int num2 = 0B11111111111111111111111111111011;//-5
		int sum = num1 + num2;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println("sum:"+sum);		
		
		//변수명 가독성
		int mp; //멤버쉽 포인트
		int membershipPoint;
		
		byte  byteData = -128;
		System.out.println(byteData);
		byteData =(byte)128;
		System.out.println(byteData);
		
		int integerNum = 1234567;
		long longNum = 22324123412L;
		
		char ch = 'A';
		System.out.println(ch);
		ch = 66;
		System.out.println(ch);
		int chin = 'A';
		System.out.println(chin);
	
		double doubleNum = 3.14;
		float floatNum = 3.14f;
		System.out.println(doubleNum+" "+floatNum);
		
		final double PI = 3.1419; //상수
		//PI = 234.1; //상수는 재할당 불가
		
		int iNum = binNum;
		System.out.println(iNum);
		iNum = (int)longNum;
		System.out.println(longNum+"  "+iNum);
		iNum = (int)floatNum;
		System.out.println(floatNum+"  "+iNum);
		doubleNum = floatNum + iNum;
		System.out.println(doubleNum);
		
		floatNum = 0.9f;
		System.out.println(doubleNum+"  "+floatNum);
		int iNum1 = (int)(doubleNum + floatNum);
		int iNum2 = (int)doubleNum + (int)floatNum;
		System.out.println(iNum1+"  "+iNum2);
		
		var num10 = 10; //int num10 =10;
		var doubNum = 13.11;//double doubNum  = 13.11;
		var str = "우리집"; //String str = "우리집";
		System.out.println(num10+" "+doubNum+" "+str);
		
	}
}
