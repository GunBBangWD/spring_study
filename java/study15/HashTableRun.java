package study15;

import java.util.*;

public class HashTableRun {
    public static void main(String[] args) {
        Hashtable<Integer, String> hmap = new Hashtable<>();
        hmap.put(2, "홍길동");
        hmap.put(6, "김유신");
        hmap.put(3, "유관순");
        hmap.put(1, "이순신");

        Hashtable<Integer, String> hmap2 = new Hashtable<>();
        hmap2.putAll(hmap);
        System.out.println(hmap2.toString());
        hmap.put(1, "이방원");
        hmap2.putAll(hmap);
        System.out.println(hmap2.toString());

        //추가
        hmap.putIfAbsent(5, "무지개"); //값이 없으면 추가
        hmap.putIfAbsent(3, "무지개");
        System.out.println(hmap);
        //수정
        hmap.replace(3, "김구");  //값이 있으면 교환
        hmap.replace(9, "김구");
        System.out.println(hmap);
        //읽기
        System.out.println(hmap.get(2));
        System.out.println(hmap.getOrDefault(100,"기본값")); //키가 없으면 출력

        Set<Map.Entry<Integer, String>> entrySet = hmap.entrySet(); //내부의 키와 값을 포함한 내용을 Set 형태로 내보냄
        System.out.println(entrySet.toString());

        Set<Integer> keySet= hmap.keySet();
        System.out.println(keySet);
        System.out.println(hmap.values());

        System.out.println(hmap.size());
        System.out.println(hmap.containsKey(3));
        System.out.println(hmap.containsValue("홍길동"));

        System.out.println(hmap.remove(5)); // 해당 키 지움
        System.out.println(hmap.remove(3,"구"));  //해당 키의 값이 같아야 지움
        System.out.println(hmap);
        System.out.println(hmap.values());

        Set<Integer> kSet = hmap.keySet();
        for (Integer key : kSet) {
            System.out.println("키: " + key + "값: " + hmap2.get(key));
        }
        Iterator<Integer> keys = kSet.iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println("키: " + key + "값: " + hmap2.get(key));
        }
    }
}
