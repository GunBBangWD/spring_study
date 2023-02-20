package study17;

import java.io.*;

public class FileReaderWriterRun {
    public static void main(String[] args) {
        File file = new File("study17/files/FileReaderWriter.txt");

        try (Writer writer = new FileWriter(file);
             Reader reader = new FileReader(file)) {
            writer.write("Korea army\n".toCharArray());
            writer.write(65);
            writer.write("Com to my home", 3, 8);
            writer.flush();

//            int data;
//            while ((data = reader.read() != -1)) {
//                System.out.println((char)data);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
