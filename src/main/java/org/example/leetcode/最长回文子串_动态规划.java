package org.example.leetcode;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class 最长回文子串_动态规划 {

    public static void main(String[] args) {
        String s = "aba";
        //System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }

    /**
     * 思路：使用动态规划：定义一个二维数组boolean类型。  第一层for循环限指定长度，然后长度固定，下标从0开始，移动。逐步找到最大的回文字符串
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        // 如果有一个字符的话，一定是一个回文字符串
        if (len == 1) {
            return s;
        }

        // 定义动态规划方程
        boolean[][] dp = new boolean[len][len];

        //初始化一些值：
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //定义最长回文子串的长度、 开始下标
        int maxLen = 1, begin = 0;

        char[] charArray = s.toCharArray();

        // 遍历字符串长度：从2开始 ， 其中需要注意 aa、bb 这种情况
        for (int L = 2; L <= len; L++) {
            // 定义左边界， 右边界根据L与左边界推算 (aba)
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;  // 右边界

                // 右边界如果大于len-1，跳过
                if (j > len -1) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    // 一定不是回文字符串
                    dp[i][j] = false;
                } else {
                    // 当L=2 时， 可能会出现aa， bb
                    if (L == 2) {
                        dp[i][j] = true;
                    } else {
                        // L > 2 时 , 动态规划方程 (去掉左边界及右边界，然后进行下一个循环，指导i==j)
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 当填充完后，进行判断，如果dp[i][j]=true ,记录回文子串
                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
