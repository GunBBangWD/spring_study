package study16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) {
        Scanner sc = null;
        try {   //try 구문 안쪽은 로컬부분 여러곳에서 사용할 변수는 try문 밖에 선언
            sc = new Scanner(new File("study16/input.txt"));
            System.out.println(sc.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (sc != null) {
                sc.close();
            }
        }


    }
}
