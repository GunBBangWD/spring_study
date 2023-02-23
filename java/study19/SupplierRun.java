package study19;

import java.util.function.*;

public class SupplierRun {
    public static void main(String[] args) {
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "Supplier 반환값";
            }
        };
        System.out.println(s.get());

        Supplier<String> s2 = ()->{return "반환값";};
        Supplier<String> s3 = ()->"반환값";
        System.out.println(s3.get());

        BooleanSupplier bs = ()->true;
        IntSupplier is = ()->5;
        LongSupplier ls = ()->10;
        DoubleSupplier ds = ()->43.3;
        System.out.println(bs.getAsBoolean()+"   "+is.getAsInt()+"   "+ls.getAsLong()+"   "+ds.getAsDouble());

    }
}
