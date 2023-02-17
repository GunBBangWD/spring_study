package study15_2;


import java.util.Arrays;

public class GenericEx {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"Hello", "World"};
        printArray(intArr);
        printArray(strArr);

    }
    private static <T> void printArray(T[] intArr) {
        for (T i:intArr) {
            System.out.println(i);
        }
    }
}
