package study17;

import java.io.*;

public class DataInputOutputStreamRun {
    public static void main(String[] args) {
        File file = new File("study17/files/file.data");

        try (
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataInputStream dis = new DataInputStream(bis);
                DataOutputStream dos = new DataOutputStream(bos)
        ) {
            dos.writeInt(99);
            dos.writeDouble(11.12);
            dos.writeChar('A');
            dos.writeChar('B');
            dos.writeUTF("우리나라");
            dos.flush();

            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readChar());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
