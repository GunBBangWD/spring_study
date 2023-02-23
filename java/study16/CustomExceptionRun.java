package study16;

class FoolExcetion extends Exception {

}

class Sample {
    public void sayNickname(String nick) {
        try {
            if (nick.equals("바보")) {
                throw new FoolExcetion();
            }
            System.out.println("당신의 별명은 " + nick + "입니다.");

        } catch (FoolExcetion e) {
            System.out.println("FoolException 발생");
        }
    }
}
public class CustomExceptionRun {
    public static void main(String[] args) {
        Sample s =new Sample();
        s.sayNickname("바보");
        s.sayNickname("말미잘");


    }
}
