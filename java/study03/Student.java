package study03;

import java.util.ArrayList;

public class Student {
	//학번 출력을 위한 공유값
	private static int sequentialNum = 1000;	
	
	int studentId; //학번
	String studentName; //이름
	int grade; //학년
	ArrayList<Subject> subjectList; //ArrayList 선언
	//기본 생성자
	public Student() {
		studentId = sequentialNum;
		sequentialNum++;
		subjectList = new ArrayList<Subject>();
	}
	//매개변수를 가진 생성자
	public Student(String studentName, int grade) {
		this();
		this.studentName=studentName;
		this.grade=grade;		
	}
	//과목을 추가하는 메서드
	public void addSubject(String name,int score) {
		Subject sub = new Subject(); //과목 객체 생성
		//과목의 이름과 성적 입력
		sub.setName(name);
		sub.setScore(score);
		subjectList.add(sub); //배열에 해당 객체를 추가
	}
	//배열 요소 값 출력
	public void showStudentInfo() {
		int total=0;
		//향상된 for문
		for(Subject s : subjectList) {
			total += s.getScore();
			System.out.println(studentId+"학생 "+studentName+"의 "
					+s.getName()+" 과목 성적은 "+s.getScore()+"입니다.");
		}
		System.out.println(studentId+"의 총점은 "+total+"입니다.");
	}
	
	public static void showSequentialNumber() {
		System.out.println(sequentialNum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
