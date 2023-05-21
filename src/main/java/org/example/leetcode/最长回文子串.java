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
public class 最长回文子串 {

    public static void main(String[] args) {
        String s = "ac";
        //System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }

    //方法二：使用动态规划：定义二维数组
    public static String longestPalindrome2(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }

        // 定义动态方程：
        boolean[][] dp = new boolean[length][length];
        int maxLen = 1; // 最大长度
        int start = 0; // 起始位置

        // 初始化一些数据
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray(); // 转换成字符数组，提高查询效率
        // 变量字符长度：从2 开始到 length
        for (int L = 2; L <= length; L++) {
            // 确定左边界
            for (int i = 0; i < length; i++) {
                // 根据L与i 可以确定右边界
                int j = L + i - 1;
                if (j > length-1 ) {
                    break; // 右边界越界， 跳出循环
                }
                // 如果左右边界不相等， 一定不是回文字符串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (L ==2) {
                        // 只有两个值 aa 、bb这种
                        dp[i][j] = true;
                    } else {
                        //如果左右两边去掉，还相等的话，说明是回文字符串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 如果dp[i][j] = true 那么就是回文子串
                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    start = i;
                }
            }

        }

        return s.substring(start, start+maxLen);
    }


    // 方法一：暴力破解 ： 时间上过不去啊
    //public static String longestPalindrome1(String s) {
    //
    //    String res = new String();
    //    if (s.length() ==1) {
    //        return s;
    //    }
    //    // 两层for循环，固定两个边界值，这样的话，只需要判断所有区间 charArray[i,j] 是否是回文，如果是的话，记录（长度及下标），依次比较找出最大的
    //    for (int i = 0; i < s.length(); i++) {
    //        for (int j = i+1; j < s.length()+1 ; j++) {
    //            //校验是否是回文返回下标及长度
    //            Map<Integer, String> integerStringMap = checkPalindrome(s.substring(i, j), i, j);
    //            Set<Integer> integers = integerStringMap.keySet();
    //            if (!integers.isEmpty()){
    //                String res1 = integerStringMap.get(integers.stream().findFirst().orElse(0));
    //                if (res1.length() > res.length()){
    //                    res = res1;
    //                }
    //            }
    //        }
    //    }
    //
    //    return res;
    //}
    //
    //private static Map<Integer, String> checkPalindrome(String s,int i, int j) {
    //    Map<Integer, String> map = new TreeMap<>(); //存放长度、回文串
    //    char[] charArray = s.toCharArray();
    //        if (charArray.length <=3  ) {
    //            if (charArray[0] == charArray[s.length()-1]) {
    //                map.put(3, s);
    //            }
    //
    //        } else {
    //            boolean flag = true;
    //            while (i<j ){
    //                if (charArray[i+1] != charArray[j-1-1] && charArray[i] == charArray[j-1]) {
    //                    flag = false;
    //                    break;
    //                }
    //            }
    //            if (flag) {
    //                map.put(s.length(), s);
    //            }
    //        }
    //    return map;
    //}


}
