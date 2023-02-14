package study14;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListRun {
    public static void main(String[] args){
        LinkedList<String> lklist = new LinkedList<>();
        lklist.add("재영");
        lklist.add("홍근");
        lklist.add("선미");
        lklist.add("미재");
        lklist.add("가영");
        lklist.add("대영");

        System.out.println(lklist);
        System.out.println(lklist.remove());
        System.out.println(lklist.size());

        Collections.sort(lklist);
        System.out.println(lklist);

        Collections.sort(lklist,Collections.reverseOrder());
        System.out.println(lklist);

        System.out.println(lklist.poll());
        System.out.println(lklist);
        System.out.println(lklist.pollLast());
        System.out.println(lklist);
    }
}
//comparable
//compar