package test2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTest1 {
    public static void main(String[] args) {

        String[] STRARR2={"Pie","pi","p","cake"};

//new Random().nextInt(45)+1
        int[] a;
        Stream<Integer> b;
        String str = Stream.generate(() ->new Random().nextInt(45)+1).distinct().limit(6).sorted().map(s->String.valueOf(s)).collect(Collectors.joining(",","{","}"));
        System.out.println(str);

//        for (int lotto:a){
//            System.out.println(lotto);
//        }

    }

    private  static final String[] STRARR={"Pie","pi","p","cake"};
    //문자열 배열의 모든 문자열 길이를 더한 결과를 출력
    public int question1(){
        return Arrays.stream(STRARR).mapToInt(s->s.length()).sum();
    }
    //문자열 배열의 문자열 중에서 가장 긴 것의 길이를 출력
    public int question2(){
        return Arrays.stream(STRARR).mapToInt(s->s.length()).max().getAsInt();
    }
    // int -> Integer 기본형->래퍼클래스 .boxed()
    //임의의 로또 번호(1~45)를 정렬하여 출력
    //배열로 반환
    public int[] question3_1(){
        return Stream.generate(() ->new Random().nextInt(45)+1).distinct().limit(6).mapToInt(s->s).sorted().toArray();
    }
    //바로 출력
    public void question3_2(){
        Stream.generate(() ->new Random().nextInt(45)+1).distinct().limit(6).mapToInt(s->s).sorted().forEach(s-> System.out.println(s));
    }
    //String로 반환
    public String question3_3(){
        return Stream.generate(() ->new Random().nextInt(45)+1).distinct().limit(6).sorted().map(s->String.valueOf(s))
                .collect(Collectors.joining(",","{","}"));
    }
    //두개의 주사위를 굴려서 나온 눈의 합이 6인 경우 모두 출력
    public List<Integer[]> question4(){

        return IntStream.rangeClosed(1,6).boxed().flatMap(i->IntStream.rangeClosed(1,6).boxed()
                .map(j->new Integer[]{i,j})).filter(arr->arr[0]+arr[1]==6).collect(Collectors.toList());
    }
}
