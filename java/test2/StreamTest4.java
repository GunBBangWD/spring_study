package test2;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest4 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("강민정", true, 1, 1, 300),
                new Student("장아름", false, 1, 1, 250),
                new Student("공승환", true, 1, 1, 200),
                new Student("권비", false, 1, 2, 150),
                new Student("김민석", true, 1, 2, 100),
                new Student("박호진", false, 1, 2, 50),
                new Student("배민국", false, 1, 3, 100),
                new Student("성우석", false, 1, 3, 150),
                new Student("송현동", true, 1, 3, 200),
                new Student("강민정", true, 2, 1, 300),
                new Student("장아름", false, 2, 1, 250),
                new Student("공승환", true, 2, 1, 200),
                new Student("권비", false, 2, 2, 150),
                new Student("김민석", true, 2, 2, 100),
                new Student("박호진", false, 2, 2, 50),
                new Student("배민국", false, 2, 3, 100),
                new Student("성우석", false, 2, 3, 150),
                new Student("송현동", true, 2, 3, 200)
        };
        System.out.println(question1(students).get(true));
        System.out.println(question1(students).get(false));

        System.out.println(question2(students));

    }
    //150점 미만 학생들을 남자와 여자로 구별하여 표시(
    static public Map<Boolean, List<Student>> question1 (Student[] stuArr) {
//        Map<Boolean, List<Student>> stmap = new HashMap<>();
//        List<Student> stlist=new ArrayList<>();
//        List<Student> stlist2=new ArrayList<>();
//        for(Student st:stuArr){
//            if (st.getScore() < 150) {
//                stlist.add(st);
//            } else {
//                stlist2.add(st);
//            }
//        }
//        Collections.sort(stlist, new maleComparator());
//        Collections.sort(stlist2, new maleComparator());
//        stmap.put(true,stlist);
//        stmap.put(false,stlist2);
//        return stmap;
        return Stream.of(stuArr).filter(s -> s.getScore() < 150).collect(Collectors.groupingBy(Student::getisMale));
    }
    //각 반별 총점을 학년 별로 나누어 구하라
    static public Map<Integer, Map<Integer, Integer>> question2(Student[] stuArr) {
//        Map<Integer, Integer> stmap = new HashMap<>();
//        Map<Integer, Integer> stmap2 = new HashMap<>();
//        Map<Integer, Map<Integer, Integer>> stmap3 = new HashMap<>();
//        for (Student st : stuArr) {
//            if(st.getGrade()==1){
//                if(stmap==null) stmap.put(st.getBan(), st.getScore());
//                else if (stmap.get(st.getBan()) == null) {
//                    stmap.put(st.getBan(), st.getScore());
//                } else {
//                    stmap.put(st.getBan(), st.getScore()+stmap.get(st.getBan()));
//                }
//                stmap3.put(st.getGrade(),stmap);
//            }else{
//                if(stmap2==null) stmap.put(st.getBan(), st.getScore());
//                else if (stmap2.get(st.getBan()) == null) {
//                    stmap2.put(st.getBan(), st.getScore());
//                } else {
//                    stmap2.put(st.getBan(), st.getScore()+stmap2.get(st.getBan()));
//                }
//                stmap3.put(st.getGrade(),stmap2);
//            }
//        }
//        return stmap3;
      return Stream.of(stuArr).collect(Collectors.groupingBy(Student::getGrade, Collectors.groupingBy(Student::getBan, Collectors.summingInt(Student::getScore))));


    }
}
