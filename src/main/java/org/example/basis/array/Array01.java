package org.example.basis.array;

import java.util.Arrays;

/**
 * @Description: 练习数组
 * @Author: zzq
 * @CreateDate: 2020/8/15
 */
public class Array01 {
    public static void main(String[] args) {
        int[][] ns = {{1, 2, 3, 4,3,3,3},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(ns.length);//3
        System.out.println(ns.toString());
        System.out.println(Arrays.toString(ns));

        int [] arr0 = ns[0];
        System.out.println(arr0.length);//7

        for (int[] n : ns) {
            for (int i : n) {
                System.out.print(i+"-");
            }
        }
        System.out.println("换行");

        System.out.println(Arrays.deepToString(ns));


        //三维数组
        int[][][] sss = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11},
                        {12, 13}
                },
                {
                        {14, 15, 16},
                        {17, 18}
                }
        };
        //打印数组
        System.out.println(Arrays.deepToString(sss));


        /**
         * 学生的成绩，计算所有学生的平均成绩
         */
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        //总成绩
        double sum = 0D;
        int courseNum = 0;
        for (int[] score : scores) {
            for (int i : score) {
                sum = sum+i;
            }
            courseNum=courseNum+score.length;
        }
        //学生个数
        int num = scores.length;

        //课程数

        double average = sum/courseNum;
        System.out.println(average);



    }


}
