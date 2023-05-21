package org.example.basis.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

    public static void main(String[] args) {
        FileInputStreamTest test = new FileInputStreamTest();
        try {
            test.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  void readFile() throws IOException {
        try (InputStream input = new FileInputStream("F:\\Exercise\\Java\\java_basis\\src\\readme.md")) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        } // 编译器在此自动为我们写入finally并调用close()
    }
}
