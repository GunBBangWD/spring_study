package study11_1;

import java.util.StringTokenizer;

import study01.Sysout;

public class StringTest {
	public static void main(String[] args) {
		byte[] bytes = 
			{73,32,108,111,118,101,32,121,111,117};
		String str = new String(bytes);
		System.out.println(str);
		
		str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
		//"자바" 없으면 "자바 없음"이라고 출력
		// 있으면 "자바"->"Java" 바꿔서 출력
		int index = str.indexOf("자바");
		if(str.contains("자바")) {
			System.out.println(str.replace("자바", "Java"));
		}else {
			System.out.println("자바 없음");
		}
		
		str="1,2,3,4,5,6,7,8,9,10";
		//이 한개의 문자열 숫자만 다 합친 결과 값 55
		int res=0;
		//1. split() 메서드 사용
		String[] token = str.split(",");
		for(int i=0;i<token.length;i++) {
			System.out.println(token[i]);
		}
		for(String s:token) {
			System.out.print(s);
			res += Integer.parseInt(s);
		}
		System.out.println();
		System.out.println(res);
		res=0;
		//2. StringTokenizer 사용
		StringTokenizer stk = new StringTokenizer(str,",");
		while(stk.hasMoreTokens()) {
			int temp = Integer.parseInt(stk.nextToken()); 
			System.out.print(temp);
			res += temp;
		}
		System.out.println();
		System.out.println(res);
		
		
		
		
		
		
		
		
	}
}
