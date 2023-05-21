package org.example.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 */
public class 有效的括号 {

    public static void main(String[] args) {
        String s = "){";
        System.out.println(isValid(s));
    }

    // 思路： 可以使用辅助栈,遇到左括号就压栈， 遇到右括号就出栈
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //遇到左括号全部压栈， 遇到右括号，出栈进行匹配，若不匹配则为false

        if (s.length() < 2) {
            return false;
        }

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i]== '[' || charArray[i]=='{') {
                stack.push(charArray[i]); // 入栈
            }

            if (charArray[i] == ')' && (stack.isEmpty() || stack.pop() != '(') ){
                return false;
            }
            if (charArray[i] == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
            if (charArray[i] == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
