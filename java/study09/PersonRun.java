package study09;

import study03.Book;

class People{
	String name;
	public void setName(String name) {
		this.name=name;
	}
	public void showInfo() {
		System.out.println(name+"사람");
	}
	public void eatFood() {
		System.out.println(name+" 음식을 먹습니다.");
	}
}
class Male extends People{
	@Override
	public void showInfo() {
		//super.showInfo();
		System.out.println(name+"남자");
	}
}
class Female extends People{
	@Override
	public void showInfo() {
		//super.showInfo();
		System.out.println(name+"여자");
	}
}

public class PersonRun {
	public static void main(String[] args) {
		Male m = new Male();
		Female f = new Female();
		m.showInfo();
		f.showInfo();
		
		People pp =new Male(); //업캐스팅
		pp.showInfo();
		pp = new Female();
		pp.showInfo();
		pp.eatFood();
		
		//instanceof
		if(pp instanceof Female) {
			System.out.println("Female instance");
		}
		if(pp instanceof Male) {
			System.out.println("Male instance");
		}
		if(pp instanceof People) {
			System.out.println("People instance");
		}
		if(pp instanceof Object) {
			System.out.println("Object instance");
		}
		
		People p = new People();
		People pm = new Male();
		People pf = new Female();
		p.showInfo();
		pm.showInfo();
		pf.showInfo();
		
		People[] pArr = new People[3];
		pArr[0]=new People();
		pArr[1]=new Male();
		pArr[2]=new Female();
		for(int i=0;i<pArr.length;i++) {
			pArr[i].showInfo();
		}
		whoAreYou(p);
		whoAreYou(pm);
		whoAreYou(pf);
		
		//다운캐스팅
		People p2 = new Male();
		p2.showInfo();
		Male m2 = (Male)p2;
		m2.showInfo();
		//Male m3 = (Male)new People();
		//Female f2 = (Female)new Book();
	}
	public static void whoAreYou(People p) {
		p.setName("선미");
		p.showInfo();
	}
	
	
	
	
	
	
	
	
}
