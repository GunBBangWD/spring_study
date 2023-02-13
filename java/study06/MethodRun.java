package study06;

public class MethodRun {
	//매개변수는 없고 반환값은 있는 경우
	String sayHi(){
		return "Hi!";
	}
	//매개변수는 있고 반환값이 없는 경우
	void sum(int a, int b){
		System.out.println(a+b);
	}
	//return;
	void sayNickname(String nick) {
		if("asshole".equals(nick)) {
			return;
		}else {
			System.out.println("My nickname is "+nick);
		}
	}
	
	
	public static void main(String[] args) {
		//사용할 메소드를 포함한 클래스의 객체를 생성
		MethodRun mr = new MethodRun();
		//해당 메소드를 호출
		//반환값 변수명 = 객체.메소드명();
		String res = mr.sayHi();
		System.out.println(res);
		//반환값이 없으면 객체.메소드명();
		mr.sum(3, 2);
		
		mr.sayNickname("asshol");
		
	}
}
