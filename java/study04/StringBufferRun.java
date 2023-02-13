package study04;

public class StringBufferRun {
	public static void main(String[] args) {
		StringBuffer sbt = new StringBuffer();
		sbt.append("hello");
		sbt.append(" ");
		sbt.append("bye");
		String result = sbt.toString();
		System.out.println(result);
		
		result = "";
		result += "hello";
		result += " ";
		result += "bye";
		System.out.println(result);
		
		
		
		StringBuffer sb1 = new StringBuffer("가나다");
		StringBuffer sb2 = new StringBuffer("가나다");
		StringBuffer sb3 = new StringBuffer("abc");
		//append
		System.out.println(sb1.equals(sb2));
		sb1.append(false);
		sb2.append(12.3);
		sb3.append("def");
		System.out.println(sb1);
		System.out.println(sb1.toString());
		System.out.println(sb2);
		System.out.println(sb3);
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.equals(sb3));
		String str1=sb1.toString();
		String str2=sb2.toString();
		System.out.println(str1.equals(str2));
		//insert()
		sb1.insert(3,"라마바사");
		System.out.println(sb1.toString());
		//delete()
		sb1.delete(7, 12);
		System.out.println(sb1.toString());
		System.out.println(sb1.indexOf("라"));
		System.out.println(sb1.length());
		//substring()
		System.out.println(sb1.substring(1,4));
		System.out.println(sb1);
		//replace()
		System.out.println(sb1.replace(1, 4, "지마"));
		System.out.println(sb1);
		//reverse()
		System.out.println(sb1.reverse());
		System.out.println(sb1);
		
	}
}
