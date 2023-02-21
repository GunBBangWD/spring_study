package study18;

public class ReferanceLamdaRun {
    public static void main(String[] args) {
        //인자, 리턴 전부 없는 메소드 람다식 사용
        FunctionInterface fi1 = new FunctionInterface() {
            @Override
            public void abMethod() {
                NormalClass nc = new NormalClass();
                nc.nomalMethod();
            }
        };
        fi1.abMethod();
        //참조변수 :: 메서드
        FunctionInterface fi2 = ()->new NormalClass().nomalMethod();
        fi2.abMethod();
        FunctionInterface fi3 = new NormalClass()::nomalMethod;
        fi3.abMethod();

        FunctionInterface fi4 = new FunctionInterface() {
            @Override
            public void abMethod() {
                NormalClass.staticMethod();
            }
        };
        FunctionInterface fi41 = NormalClass::staticMethod;
        fi41.abMethod();
        FunctionInterface fi42 = ()->NormalClass.staticMethod();
        fi42.abMethod();
        FunctionInterface fi43 = ()->{NormalClass.staticMethod();};
        fi43.abMethod();

        //인자만 있는 메서드 람다식 표현
        FunctionalInterface3 fi5 = new FunctionalInterface3() {
            @Override
            public void abMethod3(int i) {
                System.out.println(i);
            }
        };
        fi5.abMethod3(33);
        FunctionalInterface3 fi51 = (int i)->{
            System.out.println(i);
        };
        fi51.abMethod3(34);
        FunctionalInterface3 fi52 = i-> System.out.println(i);
        fi52.abMethod3(35);
        FunctionalInterface3 fi53 = System.out::println;
        fi53.abMethod3(36);

        IFforObj iff = new IFforObj() {
            @Override
            public void objectMethod(NCObj t, String k) {
                t.printString(k);
            }
        };
        iff.objectMethod(new NCObj(), "아이고");
        IFforObj iff2 = (t,k)->t.printString(k);
        iff2.objectMethod(new NCObj(), "하이고하이고");
        IFforObj iff3 = NCObj::printString;
        iff3.objectMethod(new NCObj(),"ekekekekek");

    }
}

class NormalClass {
    void nomalMethod() {
        System.out.println("일반메서드");
    }
    static void staticMethod() {
        System.out.println("정적메서드");
    }
}
interface IFforObj {
    void objectMethod(NCObj t, String k);
}
class NCObj {
    void printString(String str) {
        System.out.println(str + "객체메서드");
    }
}
