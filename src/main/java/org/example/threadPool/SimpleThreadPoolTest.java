package org.example.threadPool;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleThreadPoolTest {
    @Test
    public void testSubmit() throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool(2);
        String message = "Hello, world!";
        threadPool.submit(() -> System.out.println(message));
        Thread.sleep(1000);

        threadPool.shutdown();
    }

    @Test
    public void testSubmit2() throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool(2);

        Thread a = new Thread(() -> {
            System.out.println("this is a task .");
        });

        threadPool.submit(a);
        Thread.sleep(1000);

        threadPool.shutdown();
    }

    /**
     * 其实就是一个类，然后交给线程池中的线程执行，然后线程池中的线程进行循环，并且在run方法中执行传入的对象中的方法，
     * 只不过一般使用Runnable比较方便，因为只有一个方法run（），并且还支持函数表达式
     */
    @Test
    public void testSubmit3() throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool(2);
        //class MyThread implements Runnable {
        //    @Override
        //    public void run() {
        //        System.out.println("这是我继承Runnable接口自定义的一个线程类，但是我不会启动单独的线程，" +
        //                "会放入线程池中，交给线程池中的线程进行执行。");
        //    }
        //}
        //System.out.println("==================");
        //
        //threadPool.submit(new MyThread());
        //Thread.sleep(1000);
        class MyTest implements Runnable {
            public void run() {
                System.out.println("hello my name is blake ya !" + Thread.currentThread().getName());
            }
        }

        for (int i = 0; i < 20; i++) {
            threadPool.submit(new MyTest());
        }

        threadPool.shutdown();
    }

    @Test
    public void testSubmitAfterShutdown() throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool(2);
        threadPool.shutdown();
        Thread.sleep(1000);
        // Submit a task after shutting down the pool
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            threadPool.submit(() -> System.out.println("This task will never run"));
        });
        // Ensure that an exception is thrown
        // Negative test case

        threadPool.shutdown();
    }

    @Test
    public void testShutdown() throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool(2);
        // Shutdown the pool and wait for all tasks to complete
        threadPool.shutdown();
        Thread.sleep(1000);
        // Ensure that no more tasks can be submitted
        // Positive test case
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            threadPool.submit(() -> System.out.println("This task will never run"));
        });
    }

    @Test
    public void testWorkerThread() {
        SimpleThreadPool threadPool = new SimpleThreadPool(1);
        String message = "Hello, worker thread!";
        // Submit task to the pool and ensure it is executed
        threadPool.submit(() -> System.out.println(message + Thread.currentThread().getName()));
        // Ensure that the task was executed
        // Positive test case
        // Assert statement will print message
        // to the console
    }

    @Test
    public void testSubmit4() throws InterruptedException {
        SimpleThreadPool2 threadPool = new SimpleThreadPool2(10, 10);

        class MyTest implements Runnable {
            public void run() {
                System.out.println("hello my name is blake ya !" + Thread.currentThread().getName() + "==="+ threadPool.getCurrentPoolSize());
            }
        }

        for (int i = 0; i < 10; i++) {
            threadPool.submit(new MyTest());
        }



    }
}