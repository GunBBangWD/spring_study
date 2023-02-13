package study03;

public class StudentTest {
	public static void main(String[] args) {
		Student lee = new Student("이순신", 3);
		lee.addSubject("국어", 80);
		lee.addSubject("영어", 10);
		lee.addSubject("국사", 100);
		
		Student kim = new Student("김구",4);
		kim.addSubject("국어", 100);
		kim.addSubject("수학", 50);
		kim.addSubject("과학", 80);
		System.out.println("=================");
		System.out.println("=    성적 출력     =");
		System.out.println("=================");
		lee.showStudentInfo();
		System.out.println("=================");
		kim.showStudentInfo();
		lee.showSequentialNumber();
		kim.showSequentialNumber();
		
		
		
		
		
	}
}
