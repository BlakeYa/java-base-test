package org.example.leetcode;//package leetcode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 491. 递增子序列
// * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
// * <p>
// * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
// * <p>
// * <p>
// * <p>
// * 示例 1：
// * <p>
// * 输入：nums = [4,6,7,7]
// * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// * 示例 2：
// * <p>
// * 输入：nums = [4,4,3,2,1]
// * 输出：[[4,4]]
// */
//public class 递增子序列_X {
//    //结果集合
//    List<List<Integer>> res = new ArrayList<>();
//    //路径集合
//    LinkedList<Integer> path = new LinkedList<>();
//
//    public static void main(String[] args) {
//
//        int[] nums = {4, 6, 7, 7};
//        //int[] nums = {4, 2, 6, 7};
//        List<List<Integer>> subsequences = findSubsequences(nums);
//        System.out.println(subsequences);
//    }
//
//    public static List<List<Integer>> findSubsequences(int[] nums) {
//
//
//        public List<List<Integer>> findSubsequences(int[] nums) {
//            getSubsequences(nums,0);
//            return res;
//        }
//
//    }
//    private static void getSubsequences( int[] nums, int start ) {
//        if(path.size()>1 ){
//            res.add( new ArrayList<>(path) );
//            // 注意这里不要加return，要取树上的节点
//        }
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=start ;i < nums.length ;i++){
//            if(!path.isEmpty() && nums[i]< path.getLast()){
//                continue;
//            }
//            // 使用过了当前数字
//            if ( map.getOrDefault( nums[i],0 ) >=1 ){
//                continue;
//            }
//            map.put(nums[i],map.getOrDefault( nums[i],0 )+1);
//            path.add( nums[i] );
//            getSubsequences( nums,i+1 );
//            path.removeLast();
//        }
//    }
//
//
//}
