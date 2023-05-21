package org.example.basis.io;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File f = new File("D:");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }



}