package org.example.basis.collection.stack;

public class StackTest{
    public static void main(String[] args) {
        increase(1);
    }

    //测试栈溢出
    static int increase(int x) {
        return increase(x) + 1;
    }
}
