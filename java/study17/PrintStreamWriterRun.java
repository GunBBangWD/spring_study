package study17;

import java.io.*;

public class PrintStreamWriterRun {
    public static void main(String[] args) {
        File psf = new File("study17/files/PrintStream.txt");
        File pwf = new File("study17/files/PrintWriter.txt");

        try (
                //파일
                PrintStream ps = new PrintStream(psf);
                //파일 -> outputStream
                OutputStream os = new FileOutputStream(psf);
                PrintStream ps2 = new PrintStream(os);
                //콘솔
                PrintStream ps3 = new PrintStream(System.out);
                PrintWriter pw4 = new PrintWriter(System.out,true);

        ) {
            //PrintStream.txt 파일 생성
            ps.println(10.9);
            ps.print(10+"년"+9+"개월 \n");
            ps.printf("%s","우리나라");
            ps.println();

//            ps2.println(9);
//            ps2.print(2+"년"+4+"개월 \n");
//            ps2.printf("%s","너희 나라");
//            ps2.println();

            //콘솔창
            ps3.println(9);
            ps3.print(2+"년"+4+"개월 \n");
            ps3.printf("%s","너희 나라");
            ps3.println();

            pw4.println(9);
            pw4.print(2+"년"+4+"개월 \n");
            pw4.printf("%s","너희 나라");
            pw4.println();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
