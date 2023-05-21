package org.example.basis.stirng;

import java.util.Arrays;

public class StringTest {
        public static void main(String[] args) {
            String s = "Hello";
            System.out.println(s);
            s = s.toUpperCase();
            System.out.println(s);


            //equals yu ==
            String s1 = "hello";
            String s2 = "HELLO".toLowerCase();
            System.out.println(s1 == s2);  //false
            System.out.println(s1.equals(s2));   //true

            String aa = "A,B,C,D";
            String[] ss = aa.split(","); //[A, B, C, D]
            System.out.println(Arrays.toString(ss));
    }
}
