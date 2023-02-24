package test2;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileDirTest {
    private static String s;

    public static void main(String[] args) {
        String path = "C:\\Users\\hgh04\\Documents\\spring_study2\\java\\";
//        File src = new File(path);
//
//        File[] files = src.listFiles();
//        for (File file7 : files) {
//            System.out.println(file7.getName() + " " + (file7.isFile() ? ">파일" : "디렉토리"));
//        }
//        System.out.println("폴더: "+src.getName() + " " + src.isDirectory() + " " + src.getParent()); //파일 읽어올 수 있는 정보들
//        List<String> list = Arrays.asList(src.list());
//
//       // System.out.println(file.getName()+" "+file.isFile()+" "+file.getParent()); //파일 읽어올 수 있는 정보들
        showHierarchy(path);

    }

    //재귀함수를 통해 폴더안에 폴더가 있으면 전부 열어서 내용을 출력하는 메서드
    static void showHierarchy(String path) {
        File src = new File(path);
        File[] files = src.listFiles();
        for (File file7 : files) {
            if (file7.isDirectory()) {
                System.out.println(file7.getName() + " " + (file7.isFile() ? ">파일" : "디렉토리"+" \t"+file7.getPath()));
                showHierarchy(file7.getPath());
            }else{
                System.out.println(file7.getName() + " " + (file7.isFile() ? ">파일" : "디렉토리"+" \t"+file7.getPath()));
            }
        }
       // System.out.println("폴더: "+src.getName() + " " + src.isDirectory() + " " + src.getParent()); //파일 읽어올 수 있는 정보들


        // System.out.println(file.getName()+" "+file.isFile()+" "+file.getParent()); //파일 읽어올 수 있는 정보들


    }
}
