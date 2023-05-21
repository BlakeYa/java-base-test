package org.example.leetcode;

// https://leetcode.cn/problems/candy/
public class 分发糖果 {
    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1} ;
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        // 思路： ①左边全部比右边大， ②右边全部比左边大（倒序，且比较ratings[i]已有值的大小跟新值，取较大值即可）
        int[] candys = new int[ratings.length];  //存放分发的糖果
        int minCandys = 0;

        for (int i = 0; i < candys.length; i++) {
            candys[i] = 1;  // 初始化糖果， 没人至少一个
        }

        for (int i = 1; i < ratings.length; i++) {
            //找出所有右边比左边大的值
            if (ratings[i] > ratings[i-1]) {
                candys[i] = candys[i-1] + 1;
            }
        }

        for (int i = ratings.length-2; i >=0 ; i--) {
            // 所有左边比右边大的
            if (ratings[i] > ratings[i+1]) {
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
        }

        // 循环遍历拿到值
        for (int i = 0; i < candys.length; i++) {
            minCandys += candys[i];
        }
        return minCandys;

    }
}
