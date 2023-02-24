package study13;

interface TestInterface{
    public abstract void test();
}
class SubClass implements TestInterface{
    @Override
    public void test() {
        System.out.println("subclass study20.test() run");

    }
}
class NormalClass{
    public <T extends TestInterface> void genericMethod(T t) {
        t.test();
    }
}

public class LimitedTypeGenericClass2 {
    public static void main(String[] args) {
        NormalClass nc = new NormalClass();
        nc.genericMethod(new SubClass());

        nc.genericMethod(new TestInterface() {
            @Override
            public void test() {
                System.out.println("subclass study20.test() run");
            }
        });
    }

}
