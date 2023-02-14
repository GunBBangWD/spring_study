package study14;

import java.util.*;

public class ArrayListRun {
    public static void main(String[] args) {

        ArrayList<String> alist = new ArrayList<>();
        List<String> list = new ArrayList<>();

        alist.add("태종");
        alist.add("태세");
        alist.add("문단");
        alist.add(1, "소정");
        alist.add(2, "영화");
        System.out.println(alist);


        Iterator<String> iter = alist.iterator();
        while ((iter.hasNext())){
            System.out.println(iter.next());

        }
        System.out.println("  ");
        alist.clear();

        alist.add("예진");
        alist.add("민성");
        alist.add("현우");
        alist.add("시우");
        alist.add("지민");
        alist.add("정기");
        System.out.println(alist);
        Collections.sort(alist);
        System.out.println(alist);
        Collections.sort(alist,Collections.reverseOrder());
        System.out.println(alist);








    }
}
