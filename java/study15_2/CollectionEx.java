package study15_2;

import java.util.*;

public class CollectionEx {
    public static void main(String[] args) {
        int[] arr= {10,20,30,40,50,60,70,40,30,20};
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                System.out.println(i + "   중복");
            } else {
                System.out.println(i+"   성공");
                set.add(i);
            }
        }
        System.out.println(set);

    }
}
