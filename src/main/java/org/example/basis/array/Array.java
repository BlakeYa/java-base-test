package org.example.basis.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 练习数组
 * @Author: zzq
 * @CreateDate: 2020/8/15
 */
public class Array {
    public static void main(String[] args) {
        //冒泡排序、
        int[] ns = {2, 5, 6, 1, 3};
        System.out.println(Arrays.toString(ns));

        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));

        //比四次
        for (int i = 0; i < ns.length - 1; i++) {
            //降序
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] < ns[j + 1]) {
                    int b = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = b;
                }
            }
        }
        System.out.println(Arrays.toString(ns));

        List<String> list = new ArrayList<>();
    }
}
