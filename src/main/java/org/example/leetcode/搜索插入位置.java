package org.example.leetcode;

// https://leetcode.cn/problems/search-insert-position/

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    // 采用二分法，降低时间复杂度
    // 四种情况， 数组最前、最后、数组中有，插入数组
    private static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[0] >= target) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;  // target在数组中， 如果不在的话。
            }
        }

        // target插入nums中
        return left + 1;
    }

    // 采用这种方式， 时间复杂度为O(n)
    //public static int searchInsert(int[] nums, int target) {
    //    for (int i = 0; i < nums.length; i++) {
    //        if (nums[i] < target) {
    //            return i;
    //        }
    //    }
    //    return nums.length;
    //}
}
