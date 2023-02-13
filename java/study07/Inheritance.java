package study07;

class Parent{
	int age;
	String name;
	public Parent(){
		name = "parent";
		System.out.println("Parent() run");
	}
	public Parent(int age,String name) {
		this.age=age;
		this.name=name;
		System.out.println("parent(param) run");
	}
	public void showInfo() {
		System.out.println("이름:"+name+"/나이:"+age);
	}
}
class Child extends Parent {
	String name="Child name";
	
	public Child() {
		System.out.println("Child() run");
	}
	public Child(int age, String name) {
//		super(age,name);
		this.age=age;
		this.name=name;
		System.out.println("Child(param) run");
	}
	//show info 오버라이드
	@Override //어노테이션 annotation
	public void showInfo() {
		System.out.println(name+"("+age+")");
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Child c1 = new Child();
		System.out.println(c1.name);
		c1.showInfo();
		Parent p = new Child();
		System.out.println(p.name);
		p.showInfo();
		Child c = new Child(10,"마리");
		c.showInfo();
	}
}
