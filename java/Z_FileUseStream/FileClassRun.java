package Z_FileUseStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileClassRun {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\hgh04\\Documents\\spring_study2\\java\\study17\\study20.test";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println(dir.exists());
        File file = new File(path + "\\TestFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.exists());

        File file2 = new File("C:\\Users\\hgh04\\Documents\\spring_study2\\java\\study17\\study20.test\\TestFile.txt"); //구분자 종류
        File file3 = new File("C:/Users/hgh04/Documents/spring_study2/java/study17/study20.test/TestFile.txt");  //구분자 방식
        File file4 = new File("C:"+File.separator+"Users"+File.separator+"hgh04"+File.separator+"Documents"+File.separator+"spring_study2"
                +File.separator+"java"+File.separator+"study17"+File.separator+"test"+File.separator+"TestFile.txt");  //구분자 방식
        System.out.println(file2.exists()+file2.getAbsolutePath());
        System.out.println(file3.exists()+file3.getAbsolutePath());
        System.out.println(file4.exists()+file4.getAbsolutePath());

        System.out.println(System.getProperty("user.dir"));
        File file5 = new File("src/study17/test2.files/TestFile.txt");
        File file6 = new File("src/study17/test2.files/TestFile.txt");
        System.out.println(dir.getName() + " " + dir.isDirectory() + " " + dir.getParent()); //파일 읽어올 수 있는 정보들
        System.out.println(file.getName()+" "+file.isFile()+" "+file.getParent()); //파일 읽어올 수 있는 정보들

        File dir2 = new File(path + "\\temp");
        System.out.println(dir2.mkdir());


        //디렉토리 내부 파일들을 파일클래스 배열에 넣어서 처리
        File[] files = dir.listFiles();
        for (File file7 : files) {
            System.out.println(file7.getName() + " " + (file7.isFile() ? ">파일" : "디렉토리"));
        }

        Charset cs = Charset.forName("UTF-8"); //문자 코드형에 따른 차이점 확인용
        Charset cs2 = Charset.defaultCharset(); //기본형 == UTF-8
        System.out.println(cs2);
        System.out.println(Charset.isSupported("EUC-KR"));

        byte[] arr1 = "재승".getBytes();
        byte[] arr2 = "현명".getBytes(Charset.defaultCharset());
        byte[] arr3 = "종호".getBytes(Charset.forName("MS949"));
        byte[] arr4 = "만수".getBytes("UTF-8");

        System.out.println(arr1.length);
        System.out.println(arr2.length);
        System.out.println(arr3.length);
        System.out.println(arr4.length);

        String str1 = new String(arr1);
        String str2 = new String(arr2,Charset.defaultCharset());
        String str3 = new String(arr3,Charset.forName("MS949"));
        String str4 = new String(arr4,"UTF-8");

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);




    }
}
