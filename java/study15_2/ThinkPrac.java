package study15_2;

import java.util.*;

public class ThinkPrac {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3,6,7,2,2,2,7));
        HashSet<Integer> set = new HashSet<>(list);  // 정렬없이 중복을 제거해서 담음
        TreeSet<Integer> tset = new TreeSet<>(set);  // 오름차순으로 정렬하여 중복 제거 해서 담음
        Stack<Integer> stack = new Stack<>();
        stack.addAll(tset);
        while (!stack.empty()) System.out.println(stack.pop());
        
    }
}
