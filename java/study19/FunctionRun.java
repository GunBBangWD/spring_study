package study19;

import java.util.function.*;

public class FunctionRun {
    public static void main(String[] args) {
        Function<String ,Integer> func = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        func=s -> s.length();
        System.out.println(func.apply("ekekekek"));
        func=String::length;
        System.out.println(func.apply("ekfhkefheklfhekl"));

        IntFunction<Double> ifd = num->num*1.3;
        LongFunction<String> lfs = String::valueOf;
        DoubleFunction<Integer> dif = num->(int)num;
        BiFunction<String,String,String> bft = (addr1,addr2)->addr1+"  "+addr2;
        System.out.println(ifd.apply(123));
        System.out.println(lfs.apply(1234));
        System.out.println(dif.apply(125));
        System.out.println(bft.apply("ekekeke","tttttttttttt"));

        LongToDoubleFunction ld = num->num;
        LongToIntFunction lti = num->(int)num;
        ToIntFunction<String> tis = str -> str.length();
        ToDoubleBiFunction<Integer,Double> tbf = (intNum,doubleNum)->intNum*doubleNum;
        System.out.println(tbf.applyAsDouble(12, 13.34));


    }
}
