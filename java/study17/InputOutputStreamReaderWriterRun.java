package study17;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class InputOutputStreamReaderWriterRun {
    public static void main(String[] args) {
        File file = new File("study17/files/file2.data");
        try {
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            osw.write("aaa".toCharArray());
            osw.write("sdfad");
            osw.flush();
            osw.close();

            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);

            int data;
            char[] buffer = new char[1024];
            while ((data=isr.read(buffer)) != -1) {  //read와 readline 와 반환값이 다름
                System.out.println(Arrays.toString(buffer));
            }
            isr.close();
            is.close();

            OutputStreamWriter osw2 = new OutputStreamWriter(System.out);
            osw2.write("콘솔 출력을 위한 입력");
            osw2.flush();
            osw2.close();



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
