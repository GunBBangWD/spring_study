package study17;

import java.io.*;

public class BufferedTimeTestRun {
    public static void main(String[] args) {
        File file = new File("study17/files/bear.jpg");
        File file2 = new File("study17/files/bear2.jpg");

        long t1,t2;
        t1=System.nanoTime();
        try (
                InputStream fis = new FileInputStream(file);
                OutputStream fos = new FileOutputStream(file2);
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        t2 = System.nanoTime();
        System.out.println("버퍼없이 실행:"+t1);
        try (
                InputStream is = new FileInputStream(file);
                OutputStream os = new FileOutputStream(file2);
                BufferedInputStream bis = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(os);
                ){
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        t2=System.nanoTime()-t2;
        System.out.println("버퍼사용 실행" + t2);
        System.out.println(t1/t2);

    }
}
