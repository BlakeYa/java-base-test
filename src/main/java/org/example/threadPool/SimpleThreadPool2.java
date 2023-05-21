package org.example.threadPool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 该代码实现了一个简单的线程池，包含核心线程数和最大线程数。当提交任务时，
 * 会先判断当前线程池大小是否达到核心线程数，若未达到则直接将任务加入任务队列中，
 * 若线程池大小已达到核心线程数但未达到最大线程数，则新建线程处理任务。
 * 若线程池已满，则抛出异常。当调用shutdown方法时，会将isShutdown标志位设为true，
 * 并通知所有线程停止执行任务。WorkerThread类继承自Thread类，
 * 实现了线程执行任务的逻辑，任务队列是线程池中的共享资源，加锁以实现线程安全。
 */
public class SimpleThreadPool2 {
    private final int corePoolSize;
    private final int maxPoolSize;
    private final Queue<Runnable> taskQueue;
    private final Thread[] workers;
    private volatile boolean isShutdown = false;

    public AtomicInteger getCurrentPoolSize() {
        return currentPoolSize;
    }

    private final AtomicInteger currentPoolSize = new AtomicInteger(0);

    public SimpleThreadPool2(int corePoolSize, int maxPoolSize) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.taskQueue = new LinkedList<>();
        this.workers = new Thread[maxPoolSize];
        for (int i = 0; i < corePoolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
            currentPoolSize.incrementAndGet();
        }
    }

    public void submit(Runnable task) {
        synchronized (taskQueue) {
            if (isShutdown) {
                throw new IllegalStateException("Thread pool has been shutdown");
            }
            if (currentPoolSize.get() <= corePoolSize) {
                taskQueue.offer(task);
                taskQueue.notifyAll();
            } else if (currentPoolSize.get() < maxPoolSize) {
                int index = currentPoolSize.getAndIncrement();
                workers[index] = new WorkerThread(task, true);
                workers[index].start();
            } else {
                throw new IllegalStateException("Thread pool is full");
            }
        }
    }

    public void shutdown() {
        synchronized (taskQueue) {
            isShutdown = true;
            taskQueue.notifyAll();
        }
    }

    private class WorkerThread extends Thread {
        private Runnable initialTask;
        private boolean isOneTimeTask;

        public WorkerThread() {
            this(null, false);
        }

        public WorkerThread(Runnable initialTask, boolean isOneTimeTask) {
            this.initialTask = initialTask;
            this.isOneTimeTask = isOneTimeTask;
        }

        @Override
        public void run() {
            Runnable task = initialTask;
            try {
                while (!isShutdown || (!taskQueue.isEmpty())) {
                    if (task == null) {
                        synchronized (taskQueue) {
                            while (taskQueue.isEmpty() && !isShutdown) {
                                try {
                                    taskQueue.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (!taskQueue.isEmpty()) {
                                task = taskQueue.poll();
                            }
                        }
                    }
                    if (task != null) {
                        task.run();
                    }
                    task = null;

                    if (isOneTimeTask) {
                        break;
                    }
                }
            } finally {
                if (isOneTimeTask) {
                    currentPoolSize.decrementAndGet();
                }
            }
        }
    }
}