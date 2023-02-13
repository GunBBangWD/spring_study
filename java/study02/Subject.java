package study02;

public class Subject {
	
	public Subject() {
		System.out.println("subject constructor");
	}
	private String subjectName;
	private int score;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName=subjectName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score=score;
	}
}
