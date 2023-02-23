package study19;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class PredicateRun {
    public static void main(String[] args) {
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return (t>3);
            }
        };
        p = t->(t>3);
        System.out.println(p.test(4));

        BiPredicate<String,String> bp = (st1,st2)->st1.equals(st2);
        bp = String::equals;
        System.out.println(bp.test("app", "apple"));

    }
}
