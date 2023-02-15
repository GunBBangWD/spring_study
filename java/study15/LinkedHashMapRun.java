package study15;

import java.util.*;

public class LinkedHashMapRun {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lmap = new LinkedHashMap<>();
        lmap.put(2, "홍길동");
        lmap.put(6, "김유신");
        lmap.put(3, "유관순");
        lmap.put(1, "이순신");

        LinkedHashMap<Integer, String> lmap2 = new LinkedHashMap<>();
        lmap2.putAll(lmap);
        System.out.println(lmap2.toString());
        lmap.put(1, "이방원");
        lmap2.putAll(lmap);
        System.out.println(lmap2.toString());

        //추가
        lmap.putIfAbsent(5, "무지개"); //값이 없으면 추가
        lmap.putIfAbsent(3, "무지개");
        System.out.println(lmap);
        //수정
        lmap.replace(3, "김구");  //값이 있으면 교환
        lmap.replace(9, "김구");
        System.out.println(lmap);
        //읽기
        System.out.println(lmap.get(2));
        System.out.println(lmap.getOrDefault(100,"기본값")); //키가 없으면 출력

        Set<Map.Entry<Integer, String>> entrySet = lmap.entrySet(); //내부의 키와 값을 포함한 내용을 Set 형태로 내보냄
        System.out.println(entrySet.toString());

        Set<Integer> keySet= lmap.keySet();
        System.out.println(keySet);
        System.out.println(lmap.values());

        System.out.println(lmap.size());
        System.out.println(lmap.containsKey(3));
        System.out.println(lmap.containsValue("홍길동"));

        System.out.println(lmap.remove(5)); // 해당 키 지움
        System.out.println(lmap.remove(3,"구"));  //해당 키의 값이 같아야 지움
        System.out.println(lmap);
        System.out.println(lmap.values());

        Set<Integer> kSet = lmap.keySet();
        for (Integer key : kSet) {
            System.out.println("키: " + key + "값: " + lmap2.get(key));
        }
        Iterator<Integer> keys = kSet.iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println("키: " + key + "값: " + lmap2.get(key));
        }
    }
}
