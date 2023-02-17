package study15_2;

import java.util.Comparator;
import java.util.TreeSet;

public class SetEx {
    public static void main(String[] args) {
        TreeSet<Student> tSet = new TreeSet<>();
        tSet.add(new Student("hong",86));
        tSet.add(new Student("song",92));
        tSet.add(new Student("lee",96));
        for (Student s : tSet) {
            System.out.println(s);
        }
        Student student = tSet.last();
        Student s1 =new Student("lee",96);
        Student s2 =new Student("song",94);

        System.out.println("최고 점수: " + student.score);
        System.out.println("최고 득점자: " + student.name);
    }
}

class Student implements Comparable<Student> {
    String name;
    int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    @Override
    public int compareTo(Student student) {
        return (this.score>student.score) ? 1 : (this.score==student.score) ? 0 : -1;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
