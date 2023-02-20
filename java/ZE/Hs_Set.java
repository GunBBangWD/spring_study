package ZE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;



public class Hs_Set {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("홍길동");
        hs.addAll(Arrays.asList("이순신","유관순","김구")); //객체
        System.out.println(hs); //전체 출력
        System.out.println(hs.size());
        hs.add(null);
        hs.add(null);
        System.out.println(hs);
        System.out.println(hs.size()); //null도 하나의 요소로 판단하여 추가
        System.out.println(hs.contains("이순신"));  //값이 있는지 확인
        System.out.println(hs.remove("홍길동")); //값이 있으면 삭제
        System.out.println(hs);
        hs.clear();  //전체 삭제
        System.out.println(hs.isEmpty()); //비었는지 확인
        System.out.println("--------------------------------");


        HashSet<String> hs2 = new HashSet<>(
                Arrays.asList("홍길동","유관순","유관순","김구","이순신"));
        System.out.println(hs2);
        Iterator<String> iter = hs2.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        for (String s : hs2) {
            System.out.println(s);
        }
        String[] strArr = hs2.toArray(new String[0]);
        System.out.println(Arrays.toString(strArr));

    }
}
