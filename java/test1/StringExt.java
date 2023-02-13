package test1;

public class StringExt {
	//문자열에서 특정문자를 제거하기
	public static void main(String[] args) {
		String str = "Hello, Java!!2023";//target
		String ext = "o";
		
		//1.직접 
		char extc = 'o';
		int strLen = str.length();
		char[] chArr = new char[strLen]; 
		int j=0;
		for(int i=0;i<strLen;i++) {
			char ch=str.charAt(i);
			if(extc != ch) {
				chArr[j]=ch;
				j++;
			}
		}
		String res = new String(chArr);
		System.out.println(res);
		//배열의 종류 변경
		//2. String method
        String res2 = str.replaceAll(ext, "");
        System.out.println(res2);
        String res3 = str.replace(ext, "");
        System.out.println(res3);
        
        //3.library 사용
	}
}
