package study17;

import java.io.*;

public class BufferedIOStreamRun {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\hgh04\\Documents\\spring_study2\\java\\study17\\test2.files\\BufferedFile.txt");
        File file2 = new File("C:\\Users\\hgh04\\Documents\\spring_study2\\java\\study17\\test2.files\\BufferedOutFile.txt");

        try (
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(file2);
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
