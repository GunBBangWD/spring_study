package test2;

import java.util.Comparator;

public class Student {
    private final String name;
    private final boolean isMale;
    private final int grade;
    private final int ban;
    private final int score;
    public Student(String name, boolean isMale, int grade, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.grade = grade;
        this.ban = ban;
        this.score = score;
    }
    //getter
    public String getName() {return name;}
    public boolean getisMale() {return isMale;}
    public int getGrade() {return grade;}
    public int getBan() {return ban;}
    public int getScore() {return score;}
    @Override
    public String toString() {
        return name+", "+(isMale?"남":"여")+", "+grade+"학년 "+ban+"반 "+score+"점 ";
    }


}
class maleComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getisMale()==o2.getisMale()) return 0;
        else if (o1.getisMale()==true) return 1;
        else return -1;
    }
}
