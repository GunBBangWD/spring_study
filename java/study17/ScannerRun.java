package study17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class ScannerRun {
    public static void main(String[] args) {
        File target = new File("study17/files/input.txt");
        int st=0;

        try(Scanner sc = new Scanner(target)) {
            while (sc.hasNextInt()){
                st += sc.nextInt();
                System.out.println(st);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
