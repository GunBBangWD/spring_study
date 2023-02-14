package study14;

import java.util.HashSet;

public class HashSetMachRun {
    public static void main(String[] args) {
        HashSet<String> hst = new HashSet<>();
        hst.add("Hi");
        hst.add("hi");
        hst.add("hi");
        hst.add("hi");

        HashSet<Food1> hs1 = new HashSet<>();
        Food1 f11 = new Food1("떡볶이", "분식");
        Food1 f12 = new Food1("떡볶이", "분식");
        hs1.add(f11);
        hs1.add(f12);
        System.out.println(f11.equals(f12));
        System.out.println("f11.hashcode()" + f11.hashCode());
        System.out.println("f12.hashcode()" + f12.hashCode());
        System.out.println(hs1.size());

        HashSet<Food2> hs2 = new HashSet<>();
        Food2 f13 = new Food2("떡볶이", "분식");
        Food2 f14 = new Food2("떡볶이", "분식");
        hs2.add(f13);
        hs2.add(f14);
        System.out.println(f13.equals(f14));
        System.out.println("f11.hashcode()" + f13.hashCode());
        System.out.println("f12.hashcode()" + f14.hashCode());
        System.out.println(hs1.size());

        HashSet<Food3> hs3 = new HashSet<>();
        Food3 f15 = new Food3("떡볶이", "분식");
        Food3 f16 = new Food3("떡볶이", "분식");
        hs3.add(f15);
        hs3.add(f16);
        System.out.println(f15.equals(f16));
        System.out.println("f11.hashcode()" + f15.hashCode());
        System.out.println("f12.hashcode()" + f16.hashCode());
        System.out.println(hs3.size());


    }
}
class Food1{
    String foodName;
    String foodKind;

    Food1(String name, String kind) {
        this.foodName = name;
        this.foodKind = kind;
    }
}
class Food2{
    String foodName;
    String foodKind;

    Food2(String name, String foodKind) {
        this.foodName=name;
        this.foodKind=foodKind;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Food2 equals() call");
        if (obj instanceof Food2) {
            Food2 temp = (Food2) obj;
            return this.foodName.equals(temp.foodName) && this.foodKind.equals(temp.foodKind);
        }else {
            return false;
        }
    }
}
class Food3{
    String foodName;
    String foodKind;

    Food3(String name, String foodKind) {
        this.foodName=name;
        this.foodKind=foodKind;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Food2 equals() call");
        if (obj instanceof Food2) {
            Food2 temp = (Food2) obj;
            return this.foodName.equals(temp.foodName) && this.foodKind.equals(temp.foodKind);
        }else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        System.out.println("Food3 hashCode() call");
        return (foodName+foodKind).hashCode();
    }
}
