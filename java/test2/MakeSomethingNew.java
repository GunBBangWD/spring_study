package test2;

import java.io.*;

public class MakeSomethingNew {
    public static void main(String[] args) throws IOException {
        //test2.files 아래로 폴더명과 파일명을 입력받아서 새로 생성
        //폴더명 파일명 받아서 해당 폴더 , 파일들 새로 생성
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = "test2/files/";

        System.out.print("폴더명 입력 : ");
        String dir = reader.readLine();
        System.out.println();
        File makeDir = new File(path + dir);
        makeDir.mkdir();
        while (true){
            System.out.print("파일명 입력(종료=exit) : ");
            String file = reader.readLine();
            if(file.equals("exit"))break;
            File makefile = new File(path + dir+"/"+file);
            makefile.createNewFile();
//            if(file.equals("write")){
//                FileOutputStream fos = new FileOutputStream(path + dir+"/"+file);
//                OutputStreamWriter osw = new OutputStreamWriter(fos);
//                osw.write(reader.readLine());
//            }
        }

    }
}
