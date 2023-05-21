package org.example.basis.thread;

/**
 * @Description: 测试多线程
 * @Author: zzq
 * @CreateDate: 2020/9/3
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                System.out.println("thread end...");
            }
        };


        try {
//            Thread.sleep(20);
            System.out.println("我是在t.start之前的代码，我先执行吗？");
            t.start();
            t.join();//表示t线程先执行完了，然后执行main线程
            System.out.println("我是在t.start之后的代码，我先执行吗？");
        } catch (InterruptedException e) {
        }


        System.out.println("main end...");


    }
}