package study15_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SetCalPrac {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,6));
        ArrayList<Integer> intersaction = new ArrayList<>();//교집합
        ArrayList<Integer> union = new ArrayList<>();//합집합
        ArrayList<Integer> subtraction = new ArrayList<>();//차집합
        //교집합
        for(int i:list1){
            if(list2.contains(i)) {
                intersaction.add(i);
            }
        }
        //합집합
        union.addAll(list1);
        for(int i:list2){
            if(!list1.contains(i)){
                union.add(i);
            }
        }
        // list2-list1 차집합
        for(int i:list2){
            if(!list1.contains(i)){
                subtraction.add(i);
            }
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("교집합"+intersaction);
        System.out.println("합집합"+union);
        System.out.println("차집합 list2-list1"+subtraction);
    }
}
