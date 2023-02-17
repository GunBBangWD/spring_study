package study15_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("lee",96);
        map.put("hong", 86);
        map.put("song", 92);
        String name = "";
        int maxPoint = 0;
        int totalPoint = 0;

        //entryset

        Set<Map.Entry<String,Integer>> ents = map.entrySet();
        //Iterator<Map.Entry<String, Integer>> itr2 = ents.iterator();
        for( Map.Entry<String, Integer> elem : ents ){
            totalPoint+=elem.getValue();
            if(maxPoint<elem.getValue()){
                maxPoint=elem.getValue();
                name=elem.getKey();
            }
        }
//        keyset
        Set<String> ks = map.keySet();
        for (String key : ks) {
            totalPoint+=map.get(key);
            if(maxPoint<map.get(key)){
                maxPoint=map.get(key);
                name=key;
            }
        }

        System.out.println("평균점수: "+totalPoint/map.size()); //평균점수
        System.out.println("최고점수: " + maxPoint); //최고점수
        System.out.println("최고득점자: " + name); //최고점수
    }
}

