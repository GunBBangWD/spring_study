package study16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class TryWithResources2 {
    public static void main(String[] args) {
        String path = "C:\\Users\\hgh04\\Documents\\spring_study2\\java\\study16\\";
        try (
                Scanner sc = new Scanner(new File(path+"input.txt"));
                PrintWriter pw = new PrintWriter(
                        new File(path+"output.txt")
                )
        ) {

            String inputContent = new String(sc.nextLine().getBytes());
            System.out.println(inputContent);
            pw.write(inputContent);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
