package study10_1;

public class Passenger {
	private String pName;//승객이름
	private int money;//승객 소지금액
	
	public Passenger(String pName,int money) {
		this.pName=pName;
		this.money=money;
	}
	public void takeBus(Bus bus) {
		bus.take(1400);
		money -=1400;
	}
	public void takeSubway(Subway subway) {
		subway.take(1400);
		money -= 1400;
	}
	public void takeTrans(Trans trans,int money) {
		trans.take(money);
		this.money -= money;
	}
	
	public void showInfo() {
		System.out.println("==============");
		System.out.println("승객:"+pName);
		System.out.println("소지금:"+money);
		System.out.println("==============");
	}
}
