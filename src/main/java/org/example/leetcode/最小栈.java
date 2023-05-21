package org.example.leetcode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最小栈 {

    public static void main(String[] args) {

    }
}

// 思路： 使用链表实现
class MinStack {

    // 使用链表方式， 实现一个栈的功能
    class Node {

        int value; // 当前值
        Node next; // 下一个节点
        int min; //最小值，每一个节点都记录这个最小值即可--但是最小值可能会变，所有节点均需要变更

        private Node() {
        }

        private Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }

    }


    private Node head;

    public MinStack() {

    }

    // 压栈：3,2,1  只要保证从栈顶到栈低的节点最小值是递增的即可。
    public void push(int val) {
        if (this.head == null) {
            // 第一个入栈
            head = new Node(val, val, null);
        } else {
            // 非第一个入栈的都是头, next=上一个head
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
