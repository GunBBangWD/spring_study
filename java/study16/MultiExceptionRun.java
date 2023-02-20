package study16;

public class MultiExceptionRun {
    public static void main(String[] args) {
        CalTest ar = new MultiExceptionRun.CalTest();
        ar.exceptionProc(1, 2);
        ar.exceptionProc(2, 0);
        ar.exceptionProc(4, 2);
    }

    static class CalTest {
        private int[] arr = new int[3];

        CalTest() {
            arr[0] = 0;
            arr[1] = 100;
            arr[2] = 10;
        }

        public void exceptionProc(int first, int second) {
            try {
                System.out.println(arr[first] / arr[second]);
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException");
            } catch (Exception e) {
                System.out.println("Exception");
            } finally {
                System.out.println("finally");
            }
        }
    }
}
