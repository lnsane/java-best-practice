package com.file.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileIoMain {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\PC\\Desktop\\java-best-practice\\java\\file-io\\src\\main\\resources\\1.txt");
        System.out.println(file.getName());
        String filePath = "C:\\Users\\PC\\Desktop\\java-best-practice\\java\\file-io\\src\\main\\resources\\1.txt";
        OutputStream outputStream = new FileOutputStream(filePath);
        String s = "我爱你1";
        outputStream.write(s.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
        Writer writer = new OutputStreamWriter(new FileOutputStream(filePath, true));
        writer.append("123123123131");
        writer.flush();
        writer.close();
        Writer writer2 = new OutputStreamWriter(new FileOutputStream(filePath, true));
        writer2.append("1111");
        writer2.flush();
        writer2.close();

        InputStream inputStream = new FileInputStream(filePath);
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            System.out.println(new Character((char) len));
        }

        InputStream inputStream2 = new FileInputStream(filePath);
        int len1;
        byte[] bytes = new byte[128];
        while ((len1 = inputStream2.read(bytes)) != -1) {
//            System.out.println( new String(bytes,StandardCharsets.UTF_8));
            System.out.println(new String(bytes, 0, len1));
        }
    }
}
