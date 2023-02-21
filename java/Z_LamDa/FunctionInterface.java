package Z_LamDa;
@FunctionalInterface
public interface FunctionInterface {
    void abMethod();//함수형 인터페이스는 메소드가 하나만
}

interface FunctionalInterface1 { // input X output x
    void abMethod1();
}
interface FunctionalInterface2 { // input X output o
    int abMethod2();
}
interface FunctionalInterface3 { // input o output x
    void abMethod3(int i);
}
interface FunctionalInterface4 { // input o output o
    double abMethod4(int i,double d);
}

