package study14;

import java.util.*;

public class ListToArray {
    public static void main(String[] args) {
        ArrayList<Integer> alist = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> alist2 = new ArrayList<>(
                List.of(1, 2, 3, 4));
        LinkedList<Integer> llist = new LinkedList<>(
                Arrays.asList(5,6,7,8,9));
        Vector<Integer> vec = new Vector<>(
                Arrays.asList(9,12,34,8,9));
        Object[] obj = alist.toArray();
        System.out.println(Arrays.toString(obj));

        Integer[] int1 = alist.toArray(new Integer[8]);
        System.out.println(Arrays.toString(int1));

        Integer[] int2 = llist.toArray(new Integer[0]);
        System.out.println(Arrays.toString(int2));
        Integer[] int3 = vec.toArray(new Integer[0]);
        System.out.println(Arrays.toString(int3));


    }
}
