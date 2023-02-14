package study14;

import java.util.Arrays;
import java.util.Vector;

public class VectorRun {

    public static void main(String[] args) {
        Vector<String> vec = new Vector<>();
        Vector<String> vec2 = new Vector<>(
                Arrays.asList("사과", "오렌지", "망고", "배")
        );
        System.out.println(vec2);
        vec2.add("귤");
        vec2.addElement("감");
        System.out.println(vec2);
        System.out.println(vec2.size());
        System.out.println(vec2.capacity());

        vec2.add("귤");
        vec2.add("귤");
        vec2.add("귤");
        vec2.add("귤");

        System.out.println(vec2.size());
        System.out.println(vec2.capacity());
        System.out.println(vec2.contains("귤"));
        System.out.println(vec2.indexOf("귤"));
        System.out.println(vec2.indexOf("감"));
        System.out.println(vec2);


    }
}
