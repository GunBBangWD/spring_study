package Z_Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Last_algorithm {
    public static void main(String[] args) {
        //최종연산들
        int[] arr = {1, 3, 5, 8, 9, 10};
        //
        //count()
        long count = Arrays.stream(arr).count();
        System.out.println(count);
        System.out.println(Arrays.stream(arr).sum());
        //min() max()
        OptionalInt min = Arrays.stream(arr).min();
        OptionalInt max = Arrays.stream(arr).max();
        System.out.println(min.getAsInt());
        System.out.println(max.getAsInt());
        //average()
        OptionalDouble average = Arrays.stream(arr).average();
        System.out.println(average.getAsDouble());
        System.out.println("------------------");
        System.out.println(Arrays.stream(arr).sum());
        //reduce()
        Arrays.stream(arr).reduce((x,y)->Integer.sum(x,y)).ifPresent(x-> System.out.println(x));
        System.out.println(Arrays.stream(arr).reduce(20,Integer::sum));
        Arrays.stream(arr).reduce((x,y)->x-y).ifPresent(x-> System.out.println(x));
        System.out.println("------------------------------");
        //find()
        Arrays.stream(arr).findFirst().ifPresent(x -> System.out.println(x));
        Arrays.stream(arr).findAny().ifPresent(s-> System.out.println(s));
        //병렬처리 예시로 first, any차이점 확인
        List<String> elements = Arrays.asList("A", "AB", "C", "CD", "E", "EF");
        Optional<String> first = elements.stream().parallel().filter(str -> str.startsWith("C")).findFirst();
        System.out.println(first.get());
        elements.stream().parallel().filter(str -> str.startsWith("C")).findAny().ifPresent(s -> System.out.println(s));

        //match
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.stream(arr).anyMatch(num -> num > 8));
        System.out.println(Arrays.stream(arr).allMatch(num -> num < 9));
        System.out.println(Arrays.stream(arr).noneMatch(num -> num > 9));
        //collect()
        Stream<String> streamex = Stream.of("나", "너", "우리", "당신");
        List<String> list = streamex.collect(Collectors.toList());
        System.out.println(list);

        String[] sarr = {"apple", "orange", "lemon", "banana"};
        System.out.println(Arrays.stream(sarr).collect(Collectors.joining()));
        //delimiter=요소 사이에 넣을것들   prefix=배열 처음에 넣을것   suffix=전체 마지막에 넣을것
        System.out.println(Arrays.stream(sarr).collect(Collectors.joining(",","{","}")));
        System.out.println(Arrays.toString(sarr));

        List<Integer> nums = Arrays.asList(1, 2, 5, 6, 87, 2);
        Double ave = nums.stream().collect(Collectors.averagingDouble(num->num));
        Integer sum2 = nums.stream().collect(Collectors.summingInt(num->num));
        System.out.println(ave);
        System.out.println(sum2);

        Stream<Integer> stream = Stream.of(25,50,75,100,125,150);
        Map<Boolean, List<Integer>> m = stream.collect(Collectors.partitioningBy(a -> a == 50));
        System.out.println(m);
        System.out.println("-----------");


        Stream<Integer> stream2 = Stream.of(25,50,75,100,125,150);
        Map<Boolean, List<Integer>> m2 = stream2.collect(Collectors.groupingBy(a -> a > 50));
        System.out.println(m2);
        List<String> list2 = Stream.of("test1","test2").collect(Collectors.collectingAndThen(Collectors.toList(),Collections::<String>unmodifiableList));

    }
}
