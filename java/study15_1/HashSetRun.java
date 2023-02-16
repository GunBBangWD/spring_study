package study15_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetRun {
    public static void main(String[] args) {
        Set<String> hset1 = new HashSet<>();
        HashSet<String> hset2 = new HashSet<>();
        hset1.add("일식이");
        hset1.addAll(Arrays.asList("이식이", "삼식이", "사식이", "오식이"));
        hset2.addAll(hset1);
        //반복
        Iterator<String> itr = hset2.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        //삼식이 있는지 확인하고 있으면 구식이 추가 없으면 오식이 삭제
        if (hset2.contains("삼식이")) {
            hset2.add("구식이");
        } else hset2.remove("오식이");
        System.out.println(hset2);
        System.out.println("---------------");

        //배열로 변환해서 반복문 출력
        String[] str = hset2.toArray(new String[0]);
        for (String s : str) {
            System.out.println(s);
        }

    }
}
