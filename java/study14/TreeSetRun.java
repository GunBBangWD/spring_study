package study14;

import java.util.*;

public class TreeSetRun {
    public static void main(String[] args) {
        TreeSet<Integer> test2 = new TreeSet<>();
        test2.add(55);
        test2.add(7);
        test2.add(5);
        test2.add(44);
        System.out.println(test2);


        test2.clear();
        System.out.println(test2.isEmpty());
        for (int i = 3; i < 300; i++) {
            test2.add(i);
        }
        System.out.println(test2.descendingIterator());
        System.out.println(test2.pollFirst());
        System.out.println(test2.pollLast());

        System.out.println(test2.headSet(18));
        System.out.println(test2.headSet(18, true));
        System.out.println(test2.headSet(84));
        System.out.println(test2.headSet(84, false));
        System.out.println(test2.subSet((42), 54));
        System.out.println(
                test2.subSet(42, false, 54, true)
        );
        TreeSet<String> animalTSet = new TreeSet<>(
                Arrays.asList("Dog", "Cat", "Tiger", "Lion","Elep","Zebra")
        );
        SortedSet<String> sset = animalTSet.headSet("Z");
        NavigableSet<String> nset = animalTSet.headSet("Z", false);
        System.out.println(sset);
        System.out.println(nset.descendingSet());
        Iterator<String> iter = nset.descendingIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


    }
}
