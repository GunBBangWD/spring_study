package study14;

import java.util.TreeSet;

public class Member1 implements Comparable<Member1> {
    Integer memberId;
    String name;
    Integer age;

    Member1(int id, String name, int age) {
        this.memberId = id;
        this.name = name;
        this.age = age;
    }
    public int getMemberId() {return memberId;}
    public void setMemberId(int memberId) {this.memberId = memberId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    @Override
    public boolean equals(Object obj) {
        System.out.println("Food2 equals() call");
        if (obj instanceof Member1) {
            Member1 temp = (Member1) obj;
            return this.memberId==temp.memberId;
        }else {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return memberId.hashCode();
    }

    @Override
    public int compareTo(Member1 mem) {
       // return this.memberId.compareTo(mem.getMemberId());
       //return this.name.compareTo(mem.getName());
       // return this.age.compareTo(-1*mem.getAge());
        if(this.memberId > mem.memberId) return 1;
        else if(this.memberId == mem.memberId) return 0;
        else return -1;

    }
}
class CompareMemberTreeSet1 {
    private TreeSet<Member1> tset;

    CompareMemberTreeSet1() {
        tset = new TreeSet<Member1>();
    }

    void addMember(Member1 mem) {
        tset.add(mem);
    }

    void showAll() {
        for(Member1 mem:tset){
            System.out.println("ID: " + mem.getMemberId());
            System.out.println("name:" + mem.getName());
            System.out.println("age: " + mem.getAge());
        }
    }

}
