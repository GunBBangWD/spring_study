package study15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    int id;
    String name;
    int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        //return o1.name.compareTo(o2.name);
        if(o1.age==o2.age) return 0;
        else if (o1.age > o2.age) return 1;
        else return -1;

    }
}
public class ComparatorRun {
    public static void main(String[] args) {
        ArrayList<Student> alist = new ArrayList<>();
        alist.add(new Student(333, "해", 999));
        alist.add(new Student(111, "구름", 12));
        alist.add(new Student(222, "달", 100));;


        System.out.println(alist);
        Collections.sort(alist, new AgeComparator());
        System.out.println(alist);

        Student s1 = new Student(222, "달", 10);
        Student s2 = new Student(333,"해",9);
        AgeComparator ac = new AgeComparator();
        if (ac.compare(s1,s2)<0) {
            System.out.println(s1.name + "은 동생이다");
        }else if(ac.compare(s1,s2)==0){
            System.out.println("둘은 동갑이다");
        }else {
            System.out.println(s1.name + "은 형이다");
        }

    }
}
