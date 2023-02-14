package study14;

import java.util.TreeSet;

public class Member implements Comparable<Member> {
    Integer memberId;
    String name;
    Integer age;

    Member(int id, String name, int age) {
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
        if (obj instanceof Member) {
            Member temp = (Member) obj;
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
    public int compareTo(Member mem) {
       // return this.memberId.compareTo(mem.getMemberId());
       //return this.name.compareTo(mem.getName());
        return this.age.compareTo(-1*mem.getAge());

    }
}
class CompareMemberTreeSet{
    private TreeSet<Member> tset;

    CompareMemberTreeSet() {
        tset = new TreeSet<Member>();
    }

    void addMember(Member mem) {
        tset.add(mem);
    }

    void showAll() {
        for(Member mem:tset){
            System.out.println("ID: " + mem.getMemberId());
            System.out.println("name:" + mem.getName());
            System.out.println("age: " + mem.getAge());
        }
    }

}
