package study01;

public class Operator {

	public static void main(String[] args) {
		int num1 = 8, num2 = 4;
		System.out.println("+ :"+(num1+num2));
		System.out.println("- :"+(num1-num2));
		System.out.println("* :"+(num1*num2));
		System.out.println("/ :"+(num1/num2));
		System.out.println("% :"+(num1%num2));

		int num3=7,num4=7,num5=7;
		num3 -= 3;
		num4 = num4 - 3;
		num5 =- 3; //재할당
		System.out.println(num3+" "+num4+" "+num5);
		
		int y=0,x=10;
		y=x-- + 5 + --x;
		System.out.println(y+" "+x);
		
		System.out.println("num3:"+num3+"/num4:"+num4+"/num5:"+num5);
		System.out.println("x:"+x+"/y:"+y);
		System.out.println(num3 == num4);
		System.out.println(num3 != num5);
		System.out.println(x>y);
		System.out.println(x<=y);		
		
		char char1 = 'a';
		char char2 = 'b';
		System.out.println(char1<char2);
		
		char1 = 'v';
		char2 = 'B';
		boolean res1, res2;
		System.out.println((int)char1+" "+(int)char2);
		System.out.println(char1>'c');
		System.out.println(char2<'z');
		res1 = (char1>'c')&&(char2<'z');
		res2 = (char1<'A')||(char2>'Z');
		System.out.println("&&:"+res1);
		System.out.println("||:"+res2);
		System.out.println("!:"+!res1);
		
		System.out.println(10&7);
		System.out.println(10|7);
		System.out.println(10^7);
		System.out.println(10<<1);
		System.out.println(10>>1);
		System.out.println(7>>1);
		
		//조건 연산자, 삼항 연산자
		System.out.println( (9>7)?"True":"False" );
	}

}
