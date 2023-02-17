package study15_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListPrac {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();

        a1.add("일식이");
        a1.add("이식이");
        a1.addAll(Arrays.asList("삼식이","사식이","오식이","육식이","칠식이"));
        // 기본 for문
        for (int i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }
        System.out.println("------------");
        // 확장 for문
        for (String str : a1) {
            System.out.println(str);
        }

        System.out.println("------------");
        // Iterator
        Iterator<String> itr = a1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("----------");
        //삼식이 있는지 확인하고 있으면 구식이 추가 없으면 오식이 삭제
        if (a1.contains("삼식이")) {
            a1.add("구식이");
        } else a1.remove("오식이");
        System.out.println(a1);

        //배열로 변환해서 반복문으로 출력 확장for문
        String[] str2 = a1.toArray(new String[0]);
        for (String str : str2) {
            System.out.println(str);
        }
        System.out.println("----------");
        //배열로 변환해서 반복문으로 출력 Iterator
        Iterator<String> itr2 = a1.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }




//삼식이가 있으면 오식이 추가 없으면 오식이 삭제
    }
}
