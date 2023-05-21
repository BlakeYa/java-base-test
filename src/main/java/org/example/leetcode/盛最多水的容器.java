package org.example.leetcode;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //System.out.println(maxArea(nums));
        System.out.println(maxArea1(nums));
    }

    // 使用双指针：每次移动一个高度较低的进行左移或者右移
    public static int maxArea1(int[] height) {
        int maxArea = 0; // 初始化面积
        int left = 0, right = height.length - 1; // 初始化左右指针：分别指向最左与最右

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, min * (right - left));
            if (height[left] == min) {
                // 左边小的话，移动左边
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // todo: 超出时间限制了
    public static int maxArea(int[] height) {
        int maxArea = 0; // 初始化面积

        if (height.length == 1) {
            return maxArea;
        }

        // 计算最大面积
        for (int i = 0; i < height.length; i++) {
            // 定义一个指针
            int right = height.length - 1;

            while (right > i) {
                maxArea = Math.max((right - i) * Math.min(height[i], height[right]), maxArea);
                right--;
            }
        }
        return maxArea;
    }
}
