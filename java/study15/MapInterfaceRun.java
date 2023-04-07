package study15;

import java.util.*;

public class MapInterfaceRun {
    public static void main(String[] args) {
        HashMap<Integer, String> hmap1 = new HashMap<>(){
            @Override
            public String toString() {
                return "test";
            }
        };
        hmap1.put(103,"Lee");
        hmap1.put(102,"Kim");
        hmap1.put(101,"Kim");
        hmap1.put(102,"Hong");
        System.out.println(hmap1.size());
        System.out.println(hmap1);
        System.out.println("---------");
        //추가
        Hashtable<Integer, String> hmap2 = new Hashtable<>();
        hmap2.put(103,"Lee");
        hmap2.put(102,"Kim");
        hmap2.put(101,"Kim");
        hmap2.put(102,"Hong");
        System.out.println(hmap2.size());
        System.out.println(hmap2);
        System.out.println("---------");

        LinkedHashMap<Integer, String> hmap3 = new LinkedHashMap<>();
        hmap3.put(103,"Lee");
        hmap3.put(102,"Kim");
        hmap3.put(101,"Kim");
        hmap3.put(102,"Hong");
        System.out.println(hmap3.size());
        System.out.println(hmap3);
        System.out.println("---------");

        TreeMap<Integer, String> hmap4 = new TreeMap<>();
        hmap4.put(103,"Lee");
        hmap4.put(102,"Kim");
        hmap4.put(101,"Kim");
        hmap4.put(102,"Hong");
        System.out.println(hmap4.size());
        System.out.println(hmap4);
        System.out.println("---------");

    }
}

class AlertFunc{
    public static void
}


