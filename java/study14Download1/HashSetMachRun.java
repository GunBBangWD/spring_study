package study14Download1;

import java.util.HashSet;

public class HashSetMachRun {
	public static void main(String[] args) {
		HashSet<String> hst = new HashSet<>();
		hst.add("Hi");
		hst.add("Hi");
		hst.add("hi");
		System.out.println(hst.size());
		System.out.println(hst);
		
		HashSet<Food1> hs1 = new HashSet<>();
		Food1 f11 = new Food1("떡볶이","분식");
		Food1 f12 = new Food1("떡볶이","분식");
		hs1.add(f11);
		hs1.add(f12);
		System.out.println(f11.equals(f12));
		System.out.println("f11.hashcode()"+f11.hashCode());
		System.out.println("f12.hashcode()"+f12.hashCode());
		System.out.println(hs1.size());
		System.out.println(hs1);
		
		HashSet<Food2> hs2 = new HashSet<>();
		Food2 f21 = new Food2("떡볶이","분식");
		Food2 f22 = new Food2("떡볶이","분식");
		hs2.add(f21);
		hs2.add(f22);
		System.out.println(f21.equals(f22));
		System.out.println("f21.hashcode()"+f21.hashCode());
		System.out.println("f22.hashcode()"+f22.hashCode());
		System.out.println(hs2.size());
		System.out.println(hs2);
		
		HashSet<Food3> hs3 = new HashSet<>();
		Food3 f31 = new Food3("떡볶이","분식");
		Food3 f32 = new Food3("떡볶이","분식");
		hs3.add(f31);
		hs3.add(f32);
		System.out.println(f31.equals(f32));
		System.out.println("f31.hashcode()"+f31.hashCode());
		System.out.println("f32.hashcode()"+f32.hashCode());
		System.out.println(hs3.size());
		System.out.println(hs3);
	}
}
class Food1{
	String foodName;
	String foodKind;
	Food1(String name,String kind){
		this.foodName=name;
		this.foodKind=kind;
	}
}
class Food2{
	String foodName;
	String foodKind;
	Food2(String name,String kind){
		this.foodName=name;
		this.foodKind=kind;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Food2 equals() call");
		if(obj instanceof Food2) {
			Food2 temp = (Food2)obj;
			return this.foodName.equals(temp.foodName) &&
					this.foodKind.equals(temp.foodKind);
		}else {
			return false;
		}
	}
}
class Food3{
	String foodName;
	String foodKind;
	Food3(String name,String kind){	
		this.foodName=name;	this.foodKind=kind;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("Food3 equals() call");
		if(obj instanceof Food3) {
			Food3 temp = (Food3)obj;
			return this.foodName.equals(temp.foodName) &&
					this.foodKind.equals(temp.foodKind);
		}else {	return false; }
	}
	@Override
	public int hashCode() {
		System.out.println("Food3 hashCode() call");
		return (foodName+foodKind).hashCode();
	}
}









