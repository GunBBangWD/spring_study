package study18;

public class FunctionalInterfaceLamdaRun {
    public static void main(String[] args) {
        FunctionalInterface1 ixox = new FunctionalInterface1() {
            @Override
            public void abMethod1() {
                System.out.println("ixox 메서드");
            }
        };
        ixox.abMethod1();
        ixox = () -> System.out.println("ixox메서드");
        ixox.abMethod1();

        //리텅값만 있는 람다식
        FunctionalInterface2 ixoo = ()->{
            System.out.println("ixox메서드");
            return 100;
        };
        ixoo=()->100; //참조형태 되는지
        System.out.println(ixoo.abMethod2());

        //리턴 없고 인자만 있는 람다식
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

        //인자와 리턴 모두 있는 람다식
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
