package study20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntermediateOperatorRun {
    public static void main(String[] args) {
        IntStream is1 = IntStream.of(7, 5, 5, 2, 1, 3, 4, 6, 8, 2, 4, 8, 9);
        IntStream is2 = IntStream.of(7, 5, 5, 2, 1, 3, 4, 6, 8, 9, 3, 5, 7);
        //filter()
        is1.filter(num -> num % 2 == 0).forEach(e-> System.out.print(e+" "));
        System.out.println();
        //distinct()
        is2.distinct().filter(num->num%2!=0).forEach(e->System.out.print(e+" "));
        System.out.println();
        //map()
        Stream.of("html", "css", "java", "ajax").map(str -> str.length()).forEach(e -> System.out.print(e + " "));
        System.out.println();
        //flatMap() 쪼개진 스트림배열을 반환해야함
        String[] arr = {"i study html","you love css","java like"};
        Arrays.stream(arr).flatMap(s->Stream.of(s.split(" "))).forEach(s-> System.out.print(s+"   1    "));
        System.out.println();
        //sorted()
        IntStream.of(14, 10, 21, 35, 27).sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        List<String> lang = Arrays.asList("html", "css", "java", "ajax");
        //IntStream.of(14, 10, 21, 35, 27).sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e + " "));

        lang.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e + " "));
        System.out.println();
        //concat()
        Stream<String> st4 = Stream.of("html", "css", "java", "ajax");
        Stream<String> st5 =Stream.of("html2", "css2", "java2", "ajax2");
        Stream.concat(st4, st5).forEach(e-> System.out.print(e+"   "));
        System.out.println();
        //peek()  기본출력 내림차순 출력 오름차순 출력
        lang.stream().peek(System.out::println).sorted(Comparator.reverseOrder())
                .peek(System.out::println).sorted().forEach(e -> System.out.print(e + "  "));
        System.out.println();

        //skip() limit()
        int sum = IntStream.of(1,42,12,51,67).skip(0).peek(System.out::println).sum();
        System.out.println(sum);


    }

}
