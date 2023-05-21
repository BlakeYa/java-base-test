package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class 四数之和 {

    public static void main(String[] args) {
        int[] a = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> lists = fourSum(a, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //先进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //相比较三数之和，多一层for循环。 固定前两个值，然后使用双指针进行移动
        for (int i = 0; i < nums.length - 3; i++) { // 这里边界是-3：因为两个内层for及两个指针分别是三个数据
            if (nums[i] > 0 && nums[i] > target) {  // 如果是大于零的，且大于目标值的话，那后面的和一定是大于target的，所以直接结束
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 为了避免相同的值，如果连续两个值一样的话，跳过
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) { // 第二个固定的值是内层for循环中的第一个值： 外层中的i+1
                if (j > i +1 && nums[j] == nums[j - 1]) {  // 为了避免相同的值，如果连续两个值一样的话，跳过
                    continue;
                }
                //    定义两个双指针
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        //left指针右移动
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        // 相等
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 为了防止数据重复，如果left的下一个==left 或者 right的前一个==right 进行跳过
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
        }
        return res;
    }

}
