package study03;

public class Company {
	private static Company instance = new Company();
	
	private Company() {
		System.out.println("company 생성자 객체 생성");
	}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
