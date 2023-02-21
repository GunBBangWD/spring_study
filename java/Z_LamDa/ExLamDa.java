package Z_LamDa;

import Z_LamDa.FunctionalInterface1;
import Z_LamDa.FunctionalInterface2;
import Z_LamDa.FunctionalInterface3;
import Z_LamDa.FunctionalInterface4;

public class ExLamDa {
    public static void main(String[] args) {
        // 인자와 리턴값 모두 없는 람다식
        FunctionalInterface1 ixox = new FunctionalInterface1() {
            @Override
            public void abMethod1() {
                System.out.println("ixox메서드");
            }
        };
        ixox.abMethod1();
        ixox = () -> System.out.println("ixox메서드");
        ixox = System.out::println;
        ixox.abMethod1();

        //인자X리턴O  람다식
        FunctionalInterface2 ixoo = ()->{
            System.out.println("ixox메서드");
            return 100;
        };
        ixoo=()->100; //참조형태 되는지
        System.out.println(ixoo.abMethod2());

        //인자O리턴X  람다식
        FunctionalInterface3 ioox = new FunctionalInterface3() {
            @Override
            public void abMethod3(int i) {
                System.out.println("ioox메서드  "+i);
            }
        };
        ioox = i-> System.out.println("ioox메서드  "+i);
        ioox.abMethod3(1234);
        ioox=System.out::println;
        ioox.abMethod3(1234);

        //인자O 리턴O 람다식
        FunctionalInterface4 iooo = new FunctionalInterface4() {
            @Override
            public double abMethod4(int i, double d) {
                System.out.println("iooo메서드");
                return i*d;
            }
        };

        iooo = (i,d)->{
            System.out.println("iooo메서드");
            return i*d;
        };
        System.out.println(iooo.abMethod4(123,2.5));

    }
}
