package study14Download1;

import java.util.*;

public class NumberConvert {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(8,5,2,1,6,5,4,8,7,5,6,9,4));
        //중복제거, 오름차순 정렬
        System.out.println(numbers);
        System.out.println(new TreeSet<>(numbers));  // TreeSet 활용 자동으로 오름차순 정렬 Set으로 중복 제거

//        Collections.sort(numbers);
//        System.out.println(numbers);
//        int t=0;
//        int size=numbers.size();
//        for (int i=0;i<size-1;i++){
//            if (numbers.get(t) == numbers.get(t + 1)) {
//                numbers.remove(t+1);
//            }else{
//                t++;
//            }
//        }
//        System.out.println(numbers);

        //랜덤으로 1~10사이 숫자 20개 숫자 list 저장 오름차순 내림차순 출력 중복제거
        ArrayList<Integer> numbers2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            //numbers2.add((int)((Math.random()*10)+1));
            numbers2.add((new Random().nextInt(10)+1));
        }
        System.out.println(numbers2);
        System.out.println(new TreeSet<Integer>(numbers2));
        System.out.println(new TreeSet<Integer>(numbers2).descendingSet());






    }
}
