import java.io.*;

public class TestApp {
    public static void main(String[] args) {
        try {
            TestApp testApp = new TestApp();
            testApp.outputStreamWriteDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void fileWriteDemo() throws IOException {
        Writer writer = new FileWriter("D:\\writer.txt", true);
        writer.write("测试写入".toCharArray());
        writer.close();

    }

    private void stringWriteDemo() throws IOException {
        String str = "写入测试";
        try(StringWriter writer = new StringWriter()) {
            writer.write(str);
            writer.write(str);
            System.out.println(writer.getBuffer().toString());
        }

    }

    private void charArrayWriteDemo() throws IOException {
        try(CharArrayWriter writer = new CharArrayWriter()) {
           writer.write(65);
           writer.write(66);
           System.out.println(writer.toString());
        }

    }

    private void bufferedWriteDemo() throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\writer.txt", true);
        try(BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(65);
            writer.write(66);
        }
        fileWriter.close();

    }

    private void outputStreamWriteDemo() throws IOException {
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("D:\\writer.txt"), "gb2312")) {
            writer.write("杺");
            writer.write(66);
        }

        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("D:\\writer.txt", true), "gbk")) {
            writer.write("杺");
            writer.write(66);
        }

    }
}
