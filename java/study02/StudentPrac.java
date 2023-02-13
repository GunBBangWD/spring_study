package study02;

public class StudentPrac {

	public static void main(String[] args) {
		Student stuA = new Student();
		stuA.korea.setSubjectName("한국");
		System.out.println(stuA.korea.getSubjectName());
		
		Student stuB = new Student(100,"이순신","남성");
		//stuB.english = new Subject();
		System.out.println(stuB.english.getSubjectName());
		
		stuA.studentId=200;
		stuA.studentName="홍길동";
		stuA.address="서울 어딘가";
		stuA.gender="남성";
		
		stuA.showStudentInfo();
	}

}
