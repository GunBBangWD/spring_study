package test2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileCopyTest {
    public static void main(String[] args) {
        int data;
        int num=1;
        String target = "study17/FileClassRun.java";
        String dest = "test2/files/FileClassRun.java";
        try (FileInputStream fis = new FileInputStream(target);
             FileOutputStream fos = new FileOutputStream(dest);
             InputStreamReader isr = new InputStreamReader(fis);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
          //   BufferedReader br = new BufferedReader(isr)
        ) {
//            String line=null;
//            while ((line = br.readLine()) != null) {
//                osw.write(num+" "+line+"\n");
//                num++;
//            }
            while((data=isr.read())!=-1){
                char c=(char) data;
                if (num == 1) {
                    osw.write(String.valueOf(num++));
                }
                osw.write(c);
                if (c == '\n') {
                    osw.write(num+++" ");
                }
            }




        } catch (FileNotFoundException e) {
            System.out.println("다음 파일이 없습니다"+target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
