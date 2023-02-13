package check;

public class Profile {
	/* 개인 프로필 출력
	 *  변수에 값을 저장 후 출력
		이름: 홍길동
		학번: 2018122104
		신장: 1.78m
		남자인가요? true 
	 */
	public static void main(String[] args) {
		//변수 선언하고 값을 대입(초기화)
		String name = "홍길동";
		int id = 2018122104;
		double height = 1.78;
		boolean gender = true;
		
		//출력
		System.out.println("이름: "+name);
		System.out.print("학번 :"+id+"\n");
		System.out.printf("신장: %.2fm%n",height);
		System.out.println("남자인가요?"+gender);
		
		
		
		
		
		
		
		
	}
}
