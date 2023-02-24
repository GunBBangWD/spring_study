package study20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableRun {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        try {
            list.forEach(System.out::println);
            list = Collections.unmodifiableList(list);   //추가, 삭제 불가 ==상수화와 비슷
            list.add('e');   //UnsupportedOperation 예외
            list.remove(2);   //UnsupportedOperation 예외
        }catch(UnsupportedOperationException e) {
            e.printStackTrace();
        }
        System.out.println(list);

        List<Character> newList = new ArrayList<>(list); //상수화된 리스트를 상수화가 안된 리스트로 받아서 처리할수있다
        newList.add('k');
        System.out.println(list);
        System.out.println(newList);
        System.out.println("----------------------");
        List<Character> unmodList = Collections.unmodifiableList(newList);//상수화된 리스트를 상수화가 안된 리스트로 받아서 처리할수있다
        System.out.println(newList);
        System.out.println(unmodList);
        try {
            unmodList.add('e');
        } catch (Exception e) {
            e.printStackTrace();
        }
        newList.add('z');
        System.out.println(unmodList);




    }
}