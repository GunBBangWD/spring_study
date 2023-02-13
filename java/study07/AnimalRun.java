package study07;

class Animal{
	String name;
	public void setName(String name) {
		this.name=name;
	}
	void sleep() {
		System.out.println("zzz");
	}
}
class Dog extends Animal{
	void sleep() {
		System.out.println("그르렁 그르렁");
	}
}
class Cat extends Animal{
	void sleep() {
		System.out.println("갸르릉 갸르릉");
	}
}
class Human extends Animal{

	@Override
	void sleep() {
		System.out.println("쿨쿨");
	}

}
class PetDog extends Dog{
	PetDog(){}
	PetDog(String name){
		this.setName(name);
	}
	@Override  //annotation
	void sleep() {
		System.out.println(name+"는 골골 집에서 잡니다.");
	}
	//오버로딩
	void sleep(int hours) {
		System.out.println(name+"는 "+hours+"시간동안 잘 잡니다.");
	}
	
	
}
public class AnimalRun {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("멍멍이");
		System.out.println(dog.name);
		dog.sleep();
		Cat cat = new Cat();
		cat.setName("야옹이");
		System.out.println(cat.name);
		cat.sleep();
		PetDog pDog = new PetDog();
		pDog.setName("해피");
		pDog.sleep();
		pDog.sleep(3);
		
		//자식 클래스의 객체는 부모 클래스의 자료형으로 사용가능(is-a 관계)
		Animal dog2 = new Dog(); //Dog is a Animal
		dog2.setName("개");
		dog2.sleep();
		
		//Dog animal = (Dog)new Animal();// 오류 Animal is a Dog
		
		Dog dog3 = new PetDog("해피");
		dog3.sleep();
		
	}
}
