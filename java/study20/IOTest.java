package study20;

import java.io.*;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args)  {
        //FileOuputStream OutputStreamWriter을 활용 a.txt 파일 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("study20/test/a.txt");
        try(OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os)) {
            byte[] barr1 = "ABCDput\nOutput\npractice".getBytes();
            os.write(barr1);
            osw.write("\naaa".toCharArray());
            osw.write("sdfad");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String data;
            while ((data = br.readLine()) != null) {  //read와 readline 와 반환값이 다름
                System.out.println(data);
            }

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
