package study19;

import java.util.function.IntBinaryOperator;

class Student{
    private String name;
    private String city;
    private Integer age;

    //생성자 매개변수 1,2,3
    public Student(String st1) {
        this.name=st1;
    }
    public Student(String st1, String st2) {
        this(st1);
        this.city=st2;
    }
    public Student(String st1, String st2, Integer st3) {
        this(st1,st2);
        this.age=st3;
    }
    //toString 이름(도시,나임)
    @Override
    public String toString() {
        return name+"("+city+", "+age+")";
    }
    // getter,setter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public Integer getAge() {return age;}
    public void setAge(Integer age) {this.age = age;}
}


public class StudentInfoRun {
    public static void main(String[] args) {
        Student st = new Student("dd","서울",32);
        System.out.println(st);

        IntBinaryOperator oper;
        oper = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int x, int y) {
                return StudentInfoRun.staticSum(x,y);
            }
        };
        oper=StudentInfoRun::staticSum;



    }

    private static int staticSum(int x, int y) {
        return x+y;
    }

}
