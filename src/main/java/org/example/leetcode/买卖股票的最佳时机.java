package org.example.leetcode;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = {2,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        // 思路： 一层for循环， 找出最小值，及最大差值
        int  min = prices[0] ,maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(prices[i], min);

        }
        return maxProfit;
    }

    // 超出时间限制
    //public static int maxProfit(int[] prices) {
    //    // 思路： 使用双指针
    //    int left =0 ,max=0;
    //
    //    for (int i = 0; i < prices.length; i++) {
    //        int  right = i+1;
    //        while (right < prices.length) {
    //            if (prices[i] < prices[right]){
    //                max = Math.max(max, prices[right] - prices[i]);
    //            }
    //            right++;
    //        }
    //    }
    //    return max;
    //}


}
