package study17;

public class ArrayLamdaRun {
    public static void main(String[] args) {
        ArrIF aif = new ArrIF() {
            @Override
            public int[] sizeOfArray(int length) {
                return new int[length];
            }
        };
        aif = length -> new int[length];
        aif = int[]::new;
        int[] arr1 = aif.sizeOfArray(4);
        System.out.println(arr1.length);

        ConstLamda cl = new ConstLamda() {
            @Override
            public TwoConst getInstance() {
                return new TwoConst();
            }
        };
        TwoConst tc = cl.getInstance();
        cl = ()->new TwoConst();
        cl = TwoConst::new;

        ConstLamdaWithParam clp = new ConstLamdaWithParam() {
            @Override
            public TwoConst getInstanac(String str) {
                return new TwoConst(str);
            }
        };
        clp.getInstanac("hi");
        clp=str1->new TwoConst(str1);



    }
}

interface ArrIF {
    int[] sizeOfArray(int length);
}
class TwoConst {
    TwoConst(){
        System.out.println("기본 생성자");
    }
    TwoConst(String  string) {
        System.out.println("매개변수 생성자" + string.toString());
    }
}
interface ConstLamda {
    TwoConst getInstance();
}
interface ConstLamdaWithParam {
    TwoConst getInstanac(String str);
}
