package study17;

import java.io.*;
import java.util.Arrays;

public class FileInputOutputStreamRun {
    public static void main(String[] args) throws IOException {
        File file = new File("study17/test/TestFile.txt");
        OutputStream os1 = new FileOutputStream(file);
        byte[] barr1 = "ABCDputOutput practice".getBytes();
        os1.write(barr1);
        os1.flush();
        os1.close();

        InputStream is = new FileInputStream(file);
        int data;
        while ((data = is.read()) != -1) {
            System.out.println((char) data + " " + is.available());
        }
        is.close();
        System.out.println("----------------------");
        InputStream is2 = new FileInputStream(file);
        byte[] barr = new byte[23];
        int data2;
        while ((data2 = is2.read(barr)) != -1) {
            for (int i = 0; i < data2; i++) {
                System.out.println((char) barr[i]);
            }
            System.out.println(Arrays.toString(barr));
            System.out.println(data2);

        }
        is2.close();

        byte[] barr2 = new byte[26];

//        OutputStream os2 = new FileOutputStream(file);
//        barr2 = "InputOutput practice".getBytes();
//        os2.write(barr1);
//        os2.flush();
//        os2.close();


        byte datas = 65;
        new File("study17/files").mkdir();
        FileOutputStream fos = new FileOutputStream("study17/files/TesFileOut.txt");
        for (int i = 0; i < barr2.length; i++) {
            barr2[i]=datas++;
        }
        fos.write(barr2);
        os1.flush();
        os1.close();
//65
        InputStream is3 = new FileInputStream("study17/files/TesFileOut.txt");
        int data3;
        while ((data3 = is3.read()) != -1) {
        }





    }
}
