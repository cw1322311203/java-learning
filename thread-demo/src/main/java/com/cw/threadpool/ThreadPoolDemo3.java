package com.cw.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 14:08
 */
public class ThreadPoolDemo3 {
    //    参数一：核心线程数量
    //    参数二：最大线程数
    //    参数三：空闲线程最大存活时间
    //    参数四：时间单位  -- TimeUnit
    //    参数五：任务队列  -- 让任务在队列中等着，等有线程空闲了，再从这个队列中获取任务并执行
    //    参数六：创建线程工厂 -- 按照默认的方式创建线程对象
    //    参数七：任务的拒绝策略 -- 1.什么时候拒绝任务  提交的任务数 > 池中最大线程数量 + 队列容量
    //                             2.如何拒绝
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

        pool.shutdown();
    }
}
