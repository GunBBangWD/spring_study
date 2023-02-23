package study19;

import java.util.function.*;

public class ConsumerRun {
    public static void main(String[] args) {
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        c.accept("안녕하세요");
        Consumer<String> c2 = s-> System.out.println(s);
        c2 = System.out::println;
        c2.accept("ekekekek");

        IntConsumer c4 = System.out::println;
        LongConsumer c5 = System.out::println;
        DoubleConsumer c6 = System.out::println;
        BiConsumer<String,Integer> c7 = (name, age)->System.out.println(name+"  "+age); // 앞에 Bi가 붙으면 인자를 두 개 받는다는 의미

    }
}
