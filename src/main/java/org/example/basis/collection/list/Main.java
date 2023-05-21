package org.example.basis.collection.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * 有童鞋可能觉得使用Iterator访问List的代码比使用索引更复杂。但是，要记住，
         * 通过Iterator遍历List永远是最高效的方式。并且，由于Iterator遍历是如此常用，
         * 所以，Java的for each循环本身就可以帮我们使用Iterator遍历。
         */
        List<String> list = Arrays.asList("a","b","c");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }

        System.out.println("============");
        for (String s : list) {
            System.out.println(s);
        }



    }
}