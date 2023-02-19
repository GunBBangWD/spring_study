package ZE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Lk_List {
    public static void main(String[] args) {
        ArrayList<Integer> alist = new ArrayList();
        LinkedList<Integer> llist = new LinkedList();
        Vector<Integer> vec = new Vector();//호환 동기화
        long start = 0;
        long end = 0;
        // arraylist 와 linkedlist 의 값 생성할때 속도차이
        start = System.nanoTime();
        for (int i = 0; i < 99999; i++) {
            alist.add(0, i);
        }
        end = System.nanoTime();
        System.out.println((end-start));
        start = System.nanoTime();
        for (int i = 0; i < 99999; i++) {
            llist.add(0, i);
        }
        end = System.nanoTime();
        System.out.println((end-start));


        // arraylist 와 linkedlist 의 값 읽을때 속도차이
        start = System.nanoTime();
        for (int i = 0; i < 99999; i++) {
            alist.get(i);
        }
        end = System.nanoTime();
        System.out.println((end-start));
        start = System.nanoTime();
        for (int i = 0; i < 99999; i++) {
            llist.get(i);
        }
        end = System.nanoTime();
        System.out.println((end-start));


        // arraylist 와 linkedlist 의 값 삭제할때 속도차이
        // arraylist 는 삭제하고 옯겨주는 작업이 필요함
        start = System.nanoTime();
        for (int i = 0; i < 99999; i++) {
            alist.remove(0);
        }
        end = System.nanoTime();
        System.out.println((end-start));
        start = System.nanoTime();
        for (int i = 0; i < 99999; i++) {
            llist.remove(0);
        }
        end = System.nanoTime();
        System.out.println((end-start));

    }
}
