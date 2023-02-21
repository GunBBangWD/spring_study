package study17;

import study02.SimpleCalculator;

@FunctionalInterface
interface StringEx1{
    String showInfo(String str);
}

interface StringEx2 {
    int showInfo(String str);
}

interface StringEx3 {
    int showInfo(String str, int index);
}

interface StringEx4 {
    String showInfo(String str, int startIndex, int endIndex);
}


public class LamdaRun {
    public static void main(String[] args) {
        //익명이너클래스
        //파라미터의 길이, 맨 앞자리 글자만 반환
        StringEx1 se1 = new StringEx1() {
            @Override
            public String showInfo(String str) {
                return str.length()+"  "+str.substring(0,1);
            }
        };
        System.out.println(se1.showInfo("ekekeke"));

        //람다식
        StringEx1 se2 = str-> str.length()+"  "+str.substring(0,1);
        System.out.println(se2.showInfo("너두 나두"));


        // 람다식 형태 예시
        // () -> {}
        // ()->1
        // ()->{return 1;} //중괄호 있으면 리턴 생략불가
        // (int x)->x+1;
        // (x)->x+1;
        // x->x+1;
        //
        // (int x,int y)->x+y //인자가 2개 이상일땐 괄호 생략 안됨
        // (x,y)->x+y
        // (String str)->str.length()

        SimpleCal cal1 = new SimpleCal(){
            public int calc(int first, int second) {
                return first+second;
            }
        };
        SimpleCal cal2 = new SimpleCal(){
            public int calc(int first, int second) {
                return first-second;
            }
        };
        System.out.println(cal1.calc(4,2));
        System.out.println(cal2.calc(4,2));

        SimpleCal cal3 = (first,second)->first+second;
        SimpleCal cal4 = (first,second)->first-second;
        System.out.println(cal3.calc(4,2));
        System.out.println(cal4.calc(4,2));

        //참조타입으로 변환(::)
        //메서드 참조
        //클래스 이름::메서드이름 or 참조면수명::메서드이름
        StringEx2 se3 = str -> str.length();
        se3 = String::length;
        StringEx3 se4 = (String str, int index) -> str.charAt(index);
        se4 = String::charAt;
        StringEx4 se5 = (String str,int startIndex,int endIndex) -> str.substring(startIndex,endIndex);
        se5 = String::substring;
        String str = "참조타입의 사용법 익히기";
        System.out.println(se3.showInfo(str));
        System.out.println(se4.showInfo(str, 0));
        System.out.println(se5.showInfo(str, 0, 1));

        //생성자 참조
        //클래스명::new
        TempEx temp = a -> new Tempclass(a);
        temp = Tempclass::new;
        temp.showInfo(1);





    }

}

interface TempEx {
    Tempclass showInfo(int temp);
}

class Tempclass {
    Tempclass(int a) {

    }
}

interface SimpleCal {
    public int calc(int a, int b);

}
