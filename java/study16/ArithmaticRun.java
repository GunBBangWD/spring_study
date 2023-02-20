package study16;

import java.io.IOException;

public class ArithmaticRun {
    public static void main(String[] args) {
        try {
            byte[] list = {'a', 'b', 'c'};
            System.out.println(list[5]);  //예외발생
            System.out.println(5 / 0);
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("예외 원인: "+ e1.getMessage());
            System.out.println(e1.toString());
        } finally {
            System.out.println("반드시 실행.");
        }
    }
}
