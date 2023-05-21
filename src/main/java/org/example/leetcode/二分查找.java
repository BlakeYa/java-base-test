package org.example.leetcode;

/**
 * https://leetcode.cn/problems/binary-search/
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));

        new Thread(()->{
            System.out.println("=================");
        }).start();
    }

    // 二分法
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 左闭合右闭合区间


        while (left <= right) {  // left==right 区间依然有效
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
