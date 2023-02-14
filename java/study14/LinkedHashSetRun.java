package study14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetRun {
    public static void main(String[] args) {
        LinkedHashSet<String> lset = new LinkedHashSet<>();
        lset.add("한국");
        lset.add("중국");
        lset.add("영국");
        lset.add("미국");

        LinkedHashSet<Integer> lset2 = new LinkedHashSet<>();
        lset2.addAll(Arrays.asList(1, 2, 3, 3, 46, 343, 3333, 22));
        System.out.println(lset2);
        System.out.println(lset.size());
        System.out.println(lset.contains("미국"));
        System.out.println(lset);
        lset.clear();
        System.out.println(lset.isEmpty());
        System.out.println(lset2.isEmpty());

        Iterator<Integer> itr = lset2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        Integer[] intArr = lset2.toArray(new Integer[0]);
        System.out.println(Arrays.toString(intArr));

    }

}
