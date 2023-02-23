package study20;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamMakeRun {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(4, 6, 2, 4, 1, 2));

        Stream<Integer> collectionStream = alist.stream();
//        collectionStream.forEach(System.out::println);
        collectionStream.forEach(num-> System.out.println(num));

        String[] sarr = new String[]{"넷", "셋", "둘", "하나"};
        Stream<String> arrayStream = Arrays.stream(sarr);
        arrayStream.forEach(str-> System.out.println(str+"  "));
        System.out.println("----------------------------------");
        arrayStream = Arrays.stream(sarr, 1, 3);
        arrayStream.forEach(str-> System.out.println(str+"  "));
        System.out.println();
        //기본형
        Stream<Double> doubleStream = Stream.of(3.2, 6.7, 8.0, 3.6, 5.3, 5.6, 2.5);
        doubleStream.forEach(num -> System.out.print(num + " "));
        System.out.println();
        IntStream intStream = IntStream.range(1, 5); // 5 포함 안함
        intStream.forEach(num-> System.out.print(num+"  "));
        LongStream longStream = LongStream.rangeClosed(1,5); // 5 포함
        System.out.println();
        longStream.forEach(num-> System.out.print(num+"  "));
        System.out.println();
        DoubleStream ds = new Random().doubles(3); //더블랜덤수 3개 반환
        ds.forEach(num-> System.out.print(num+" "));
        System.out.println();

        IntStream is = "i love you".chars();
        is.forEach(num -> System.out.print(num + ""));
        System.out.println();


        //정규식, 정규표현식
        Stream<String> stream = Pattern.compile(", ").splitAsStream("서울, 대전, 대구, 부산, 울산");
        stream.forEach(str -> System.out.print(str + " "));
        System.out.println();

        //파일 활용
        System.out.println(System.getProperty("user.dir"));
        Stream<String> stream1 = Files.lines(Paths.get("study20/testfile.txt"), Charset.forName("UTF-8"));
        stream1.forEach(str-> System.out.print(str+" "));

        //비어있는 스트림도 처리 가능
        ArrayList<String> alist2 = new ArrayList<>();
        Stream<String> stream2 = (alist2==null||alist2.isEmpty())?Stream.empty():alist2.stream();
        stream2.forEach(str-> System.out.println(str+" "));
        System.out.println();

        //Stream.builder()
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> bstream=builder.add("수학").add("물리").build();
        Stream<String> builder2 =Stream.<String>builder().add("국어").add("eeee").build();
        builder2.forEach(str-> System.out.print(str+" "));
        System.out.println();

        //generate()
        Stream<String> gstream = Stream.generate(() -> "WOWOE").limit(4);
        gstream.forEach(str-> System.out.print(str+" "));
        //iterate
        Stream.iterate(100,num->num+2).limit(5).forEach(num-> System.out.print(num+" "));
        System.out.println();



    }
}
