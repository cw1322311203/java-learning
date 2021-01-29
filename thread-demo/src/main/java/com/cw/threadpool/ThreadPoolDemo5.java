package com.cw.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 14:08
 * <p>
 * <p>
 * 什么时候拒绝任务?   当 提交的任务数 > 池中最大线程数量 + 队列容量 时(即 提交的任务数 > maximumPoolSize + workQueue)
 * <p>
 * 任务的拒绝策略
 * ThreadPoolExecutor.AbortPolicy: 		    丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
 * ThreadPoolExecutor.DiscardPolicy： 		   丢弃任务，但是不抛出异常 这是不推荐的做法。
 * ThreadPoolExecutor.DiscardOldestPolicy：    抛弃队列中等待最久的任务 然后把当前任务加入队列中。
 * ThreadPoolExecutor.CallerRunsPolicy:        调用任务的run()方法绕过线程池直接执行。
 */
public class ThreadPoolDemo5 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,
                2,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        // 5 > 2 + 1
        for (int i = 1; i <= 5; i++) {
            int y = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "--" + y);
            });
        }

        pool.shutdown();
    }
}
