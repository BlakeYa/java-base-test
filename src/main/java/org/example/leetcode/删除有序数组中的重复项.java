package org.example.leetcode;

/**
 * 26 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        //思路： 按照题目应该是重写这个数组，并且修改了最前面的数组下标对应的数据， 所以双指针应该从前到后
        int left = 0, right = 1;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                // 如果相同的话， 右指针移动-- nums[right]
                right++; // nums[right++] 用来记录数组中下一个数字
            } else {
                left++; // 左指针移动，将右指针对应的值赋值
                nums[left] = nums[right];
                right++;
            }
        }
        return left + 1;
    }
}
