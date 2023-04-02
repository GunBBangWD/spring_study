package ZE;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TrMap_Skill {
    public static void main(String[] args) {
        TreeMap<Integer, String> tmap = new TreeMap<>();
        for (int i = 2; i <= 40; i+=2) {
            tmap.put(i, (i / 2) + "번 아이");
        }
        System.out.println(tmap.put(99,"1233"));

        System.out.println(tmap.toString());//저장은 트리구조로 되어있으나 출력할때는 순서대로처럼 느껴짐

        System.out.println(tmap.firstKey());  //첫 번째 키값 반환
        System.out.println(tmap.lastKey()); //마지막 키값 반환

        Map.Entry<Integer, String> fentry = tmap.firstEntry(); //첫 번째 것을 엔트리(Entry<키,값) 형태로 가져옴
        System.out.println(fentry);
        System.out.println(tmap.lastEntry()); //마지막 것을 엔트리(Entry<키,값) 형태로 가져옴
        System.out.println("---------인자로 받은 인덱스기준 바로 자신을 제외 다음(higher)과 이전(lower) 것을 반환 -----------");
        System.out.println(tmap.higherKey(20));
        System.out.println(tmap.lowerKey(20));
        System.out.println(tmap.higherEntry(30));
        System.out.println(tmap.lowerEntry(10));
        System.out.println("---------인자로 받은 인덱스 기준 자신 포함 다음(floorKey)과 이전(ceiling) 것을 반환-----------------");
        System.out.println(tmap.floorKey(17));
        System.out.println(tmap.ceilingKey(17));
        System.out.println(tmap.floorEntry(17));
        System.out.println(tmap.ceilingEntry(17));
        System.out.println("----------첫번째와 마지막 인자를 지우면서 엔트리(Entry<키,값) 형태로 반환-----------");
        System.out.println(tmap.pollFirstEntry());
        System.out.println(tmap.pollLastEntry());
        System.out.println(tmap);
        System.out.println("---------------------");

        SortedMap<Integer, String> head = tmap.headMap(18);
        NavigableMap<Integer, String> head2 = tmap.headMap(18, true);
        System.out.println(tmap.headMap(18));  //인자보다 키값이 작은 것들을 반환   뒤에 true, false가 같은거 포함 여부 판단 tail의 default = false
        System.out.println(tmap.headMap(18, true)); //인자와 키값이 같은것 포함 작은것들을 반환
        System.out.println(tmap.tailMap(32)); //인자보다 키값이 큰것들을 반환
        System.out.println(tmap.tailMap(32, false)); //인자보다 키값이 큰것들을 반환 뒤에 true, false가 같은거 포함 여부 판단 tail의 default = true
        System.out.println(tmap.subMap(18, 32));  // 두 인자 사이의 것들을 반환
        System.out.println(tmap.subMap(18, false, 32, true));
        System.out.println("---------------------");

        System.out.println(tmap.keySet()); //키값들만 Set형태로 반환
        System.out.println(tmap.entrySet()); //엔트리(Entry<키,값) 형태로 반환
        System.out.println(tmap.values()); // 값들만 반환
        System.out.println("----------TreeMap 의 추가 기능-----------");
        System.out.println(tmap.descendingMap()); // 역순으로 정렬해서 반환
        System.out.println(tmap.descendingKeySet()); // 역순으로 정렬해서 키값만 반환
        System.out.println("------------교환 부분 ---------");
        System.out.println(tmap.replace(4, "4번 녀")); // 키의 값을 교환
        System.out.println(tmap);
        System.out.println(tmap.replace(4, "4번 녀석", "안나올 녀석")); // 키의 값을 확인하고 맞으면 교환
        System.out.println(tmap);
        System.out.println("---------------------");
        System.out.println(tmap.remove(8));
        System.out.println(tmap.remove(6, "3번 놈"));// 키의 값이 맞으면 삭제
        System.out.println(tmap);

    }
}
