package study02;

class Birthday{
	//필드 멤버변수
	private int date;
	private int month;
	private int year;
	//생성자
	public Birthday() {
		//this.year=1980;this.month=3;this.date=8;
		this(1980,3,8);
	}
	
	public Birthday(int year,int month,int date) {
		this.year=year;
		this.month=month;
		this.date=date;
	}
	
	//변수 관련 메소드 getter setter
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String showBirthday() {
		return year+"년"+month+"월"+date+"일";
	}	
}

public class BirthData {
	public static void main(String[] args) {
		Birthday bDay1 = new Birthday();
		System.out.println(bDay1.getDate());

		System.out.println(bDay1.getYear());
		bDay1.setYear(2000);
		System.out.println(bDay1.getYear());
		System.out.println(bDay1.showBirthday());

		Birthday bDay2 = new Birthday(2000,10,8);
		System.out.println(bDay2.showBirthday());
	}
}
