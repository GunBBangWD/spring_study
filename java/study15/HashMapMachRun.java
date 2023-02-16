package study15;

import java.util.HashMap;

class Food1{
	String foodName;
	Food1(String name){
		foodName=name;
	}
	@Override
	public String toString() {
		return foodName;
	}
}
class Food2{
	String foodName;
	Food2(String name){
		foodName=name;
	}
	@Override
	public String toString() {
		return foodName;
	}
	@Override
	public int hashCode() {
		return foodName.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Food2) {
			return this.foodName.equals(((Food2)obj).getFoodName());
		}else {
			return false;
		}
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName=foodName;
	}
}

public class HashMapMachRun {
	public static void main(String[] args) {
		HashMap<Integer,String> hm = new HashMap<>();
		hm.put(3, "Hi");
		hm.put(4, "Hi");
		hm.put(3, "hi");
		System.out.println(hm.size());
		System.out.println(hm);
		System.out.println();
		
		HashMap<Food1,String> hmap = new HashMap<>();
		Food1 f1 = new Food1("떡볶이");
		System.out.println(f1);
		Food1 f2 = new Food1("떡볶이");
		hmap.put(f1, "분식");
		hmap.put(f2, "분식");
		System.out.println(f1.equals(f2));
		System.out.println("f1.hashcode():"+f1.hashCode());
		System.out.println("f2.hashcode():"+f2.hashCode());
		System.out.println(hmap.size());
		System.out.println(hmap);
		System.out.println();
		
		HashMap<Food2,String> hmap2 = new HashMap<>();
		Food2 f3 = new Food2("떡볶이");
		Food2 f4 = new Food2("떡볶이");
		hmap2.put(f3, "분식");
		hmap2.put(f4, "양식");
		System.out.println(f3.equals(f4));
		System.out.println("f3.hashcode():"+f3.hashCode());
		System.out.println("f4.hashcode():"+f4.hashCode());
		System.out.println(hmap2.size());
		System.out.println(hmap2);
		System.out.println();
		
	}
}








