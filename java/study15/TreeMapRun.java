package study15;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapRun {
    public static void main(String[] args) {
        TreeMap<Integer, String> tmap = new TreeMap<>();
        for (int i = 2; i <= 40; i+=2) {
            tmap.put(i, (i / 2) + "번 아이");
        }
        System.out.println(tmap.toString());//저장은 트리구조로 되어있으나 출력할때는 순서대로처럼 느껴짐

        System.out.println(tmap.firstKey());
        System.out.println(tmap.lastKey());

        Map.Entry<Integer, String> fentry = tmap.firstEntry();
        System.out.println(fentry);
        System.out.println(tmap.lastEntry());

        System.out.println(tmap.higherKey(20));
        System.out.println(tmap.lowerKey(20));
        System.out.println(tmap.higherEntry(30));
        System.out.println(tmap.lowerEntry(10));
        System.out.println(tmap.floorKey(17));
        System.out.println(tmap.ceilingKey(17));
        System.out.println(tmap.floorEntry(17));
        System.out.println(tmap.ceilingEntry(17));

        System.out.println("---------------------");
        System.out.println(tmap.pollFirstEntry());
        System.out.println(tmap.pollLastEntry());
        System.out.println(tmap);
        System.out.println("---------------------");

        SortedMap<Integer, String> head = tmap.headMap(18);
        NavigableMap<Integer, String> head2 = tmap.headMap(18, true);
        System.out.println(tmap.headMap(18));
        System.out.println(tmap.headMap(18, true));
        System.out.println(tmap.tailMap(32));
        System.out.println(tmap.tailMap(32, false));
        System.out.println(tmap.subMap(18, 32));
        System.out.println(tmap.subMap(18, false, 32, true));
        System.out.println("---------------------");

        System.out.println(tmap.keySet());
        System.out.println(tmap.entrySet());
        System.out.println(tmap.values());
        System.out.println("----------TreeMap 의 추가 기능-----------");
        System.out.println(tmap.descendingMap());
        System.out.println(tmap.descendingKeySet());
        System.out.println("---------------------");
        System.out.println(tmap.replace(4, "4번 녀석"));
        System.out.println(tmap.replace(4, "4번 녀석", "안나올 녀석"));
        System.out.println(tmap);
        System.out.println("---------------------");

        System.out.println(tmap.remove(8));
        System.out.println(tmap.remove(6, "3번 놈"));
        System.out.println(tmap);
    }
}
