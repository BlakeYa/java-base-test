package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "dvdf";
        int maxLen = lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }

    //解法一：使用滑动窗口解决
    private static int lengthOfLongestSubstring(String s) {
        //思路：使用滑动窗口解决
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(); // 字符最后出现的位置

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) { //说明出现了，并且现在这个位置在left左边，所以需要在窗口中移除
                left = map.get(c) + 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
            map.put(c, i);
        }

        return maxLen;

    }

    //解法二： 优化上述代码
    private static int lengthOfLongestSubstring2(String s) {
        //思路：使用滑动窗口解决
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(); // 字符最后出现的位置
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(c, right);
            right++;
        }
        return maxLen;

    }
}
