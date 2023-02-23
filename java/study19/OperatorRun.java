package study19;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorRun {
    public static void main(String[] args) {
        UnaryOperator<Double> uo = new UnaryOperator<Double>() {
            @Override
            public Double apply(Double t) {
                return t*12.3;
            }
        };
        BinaryOperator<String> bo = new BinaryOperator<String>() {
            @Override
            public String apply(String t, String u) {
                return t+u;
            }
        };
        uo=t->t*12.3;
        bo=(t,u)->t+u;
        System.out.println(uo.apply(3.4));
        System.out.println(bo.apply("어서","오세요"));
    }
}
