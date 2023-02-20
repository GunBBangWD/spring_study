package study16;

public class ThrowsRun {
    //    static void handleException() {
//        try {
//            System.out.println("호출된 메서드");
//            Exception e = new Exception();
//            throw e;
//        } catch (Exception e) {
//            System.out.println("호출된 메서드에서 예외처리");
//        }
//    }
    static void handleException() throws Exception {
        System.out.println("호출된 메서드");
        Exception e = new Exception();
        throw e;
    }
    public static void main(String[] args) {
        try {
            handleException();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("메소드에서 발생한 예외회피를");
            System.out.println("main에서 예외처리함.");

        }

    }
}
