package study14;

import java.util.*;

public class SetInterfaceClass {
    public static void main(String[] args) {
        HashSet<String> hset = new HashSet<>();
        hset.add("A");
        Set<String> hset2 = new HashSet<>(
                Arrays.asList("A", "B", "C")
        );
        hset2.addAll(hset);
        System.out.println(hset);
        System.out.println(hset2);

        LinkedHashSet<String> lset = new LinkedHashSet<>();
        lset.add("A");
        Set<String> lset2 = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
        System.out.println(lset);
        System.out.println(lset2);

        TreeSet<String> tset = new TreeSet<>();
        tset.add("A");
        Set<String> tset2 = new TreeSet<>(Arrays.asList("A", "B", "C"));
        System.out.println(tset);
        System.out.println(tset2);




    }

}
