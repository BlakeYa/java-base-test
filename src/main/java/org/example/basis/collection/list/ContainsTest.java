package org.example.basis.collection.list;

import java.util.Arrays;
import java.util.List;

public class ContainsTest{
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        System.out.println(list.contains("C")); // true
        System.out.println(list.contains("X")); // false
        System.out.println(list.indexOf("C")); // 2
        System.out.println(list.indexOf("X")); // -1

    }
}