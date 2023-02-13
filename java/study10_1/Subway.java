package study10_1;

public class Subway extends Trans {
	private int lineNumber;
	
	public Subway(int lineNumber) {
		this.lineNumber=lineNumber;
	}
	public void take(int money) {
		this.income += money;
		passengerCount++;
		System.out.println("지하철탐.");
	}
	@Override
	public void showInfo() {
		System.out.println("==============");
		System.out.println(lineNumber+"호선 Subway");
		System.out.println("탑승자수:"+passengerCount);
		System.out.println("총 수익:"+income);
		System.out.println("==============");
	}

}
