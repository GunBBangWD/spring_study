package test2;

import java.util.List;
import java.util.stream.IntStream;

public class StreamTest5 {
    public static void main(String[] args) {
        List<String> strList = List.of("mango", "banana", "apple");

        strList.stream().sorted().forEach(e -> System.out.print(e + " "));
    }
}
