package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //先将数组进行排序，从小到大
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        //思路：一层for循环，然后左右两边两个双指针
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1, right = nums.length - 1;

            if (nums[i] > 0) { //从小到大的数据，如果一个数据大于0，那和一定是大于0的
                break;
            }

            //如果当前数字与前一个数据相同，跳过本次循环避免数据重复 （因为这个是基数，后面的指针一定会匹配到相同的数据）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //移动双指针 left、 right
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    //表示右边指针所指数据太大，左移右指针
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //防止重复，需要排查一下
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}
