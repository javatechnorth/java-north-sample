package com.mifan;

import java.io.*;

public class ReaderDemo {

    private void fileReaderDemo() throws Exception {
        Reader reader = new FileReader("D:\\readerDemo.txt");
        int n;
        while ((n = reader.read()) != -1) {
            System.out.print((char)n);
        }
        reader.close();

    }

    private void inputStreamReaderDemo() throws Exception {
        InputStream inputStream = new FileInputStream("D:\\readerDemo.txt");
        try(Reader reader = new InputStreamReader(inputStream, "utf-8")) {
            int n;
            while ((n = reader.read()) != -1) {
                System.out.print((char)n);
            }
        }
    }

    private void stringReaderDemo() throws Exception {
        try(Reader reader =  new CharArrayReader("这是测试代码".toCharArray())) {
            char[] buffer = new char[1024];
            while ((reader.read(buffer)) != -1) {
                System.out.print(buffer);
            }
        }
    }

    private void bufferedReaderDemo() throws Exception {
        try(BufferedReader reader =  new BufferedReader(new FileReader("D:\\readerDemo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        ReaderDemo demo = new ReaderDemo();
        try {
            demo.bufferedReaderDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
