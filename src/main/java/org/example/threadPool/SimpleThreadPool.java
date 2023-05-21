package org.example.threadPool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这是一个简单的线程池，构造函数中传入线程池大小，初始化一个任务队列，以及线程数组。
 * 利用workerThread实现Runnable接口，重写run方法，使用wait和notifyAll实现任务队列的阻塞等待，
 * 当有新的任务到达时，唤醒阻塞队列中的线程执行任务，当线程池关闭时，所有线程都会退出。
 * 提供了submit方法将任务添加到任务队列中，提供了shutdown方法关闭线程池。
 */
public class SimpleThreadPool {
    private final int poolSize; // 线程池大小
    private final Queue<Runnable> taskQueue; // 任务队列
    private final Thread[] workers; // 线程数组
    private volatile boolean isShutdown = false; // 线程池是否关闭

    public SimpleThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.taskQueue = new LinkedList<>();
        this.workers = new Thread[poolSize];
        // 初始化线程数组
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();  // 启动所有线程
        }
    }

    /**
     * 向任务队列添加任务
     *
     * @param task 待执行的任务
     */
    public void submit(Runnable task) {
        synchronized (taskQueue) {
            // 如果线程池已经关闭，则抛出异常，禁止提交任务
            if (isShutdown) {
                throw new IllegalStateException("Thread pool has been shutdown");
            }
            // 将任务添加到任务队列中
            taskQueue.offer(task); // 增加一个元素到队列尾部，成功返回true，否则返回false。
            // 唤醒所有因等待任务而阻塞的线程
            taskQueue.notifyAll();
        }
    }

    public void shutdown() {
        synchronized (taskQueue) {
            isShutdown = true;
            taskQueue.notifyAll();
        }
    }

    private class WorkerThread extends Thread {
        public void run() {
            Runnable task = null;
            while (!isShutdown || (!taskQueue.isEmpty())) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            taskQueue.wait();  // 如果队列为空、并且线程池未关闭，进行等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!taskQueue.isEmpty()) {
                        // 当队列不为空时，删除队列头部的元素，如果队列为空，返回null。
                        task = taskQueue.poll();
                    }
                }
                // 当任务不为null时，执行任务
                if (task != null) {
                    task.run();
                }
                task = null;
            }
        }
    }
} 
