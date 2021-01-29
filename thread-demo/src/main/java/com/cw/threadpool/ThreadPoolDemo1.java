package com.cw.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 13:50
 * <p>
 * - static ExecutorService newCachedThreadPool()   创建一个默认的线程池
 * - static ExecutorService newFixedThreadPool(int nThreads)	    创建一个指定最多线程数量的线程池
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) throws InterruptedException {
        // 1.创建一个默认的线程池对象，池子默认为空，默认最多可以容纳int类型的最大值
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Executors:可以帮助我们创建线程池对象
        // ExecutorService:可以帮助我们控制线程池

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        Thread.sleep(2000);// 不加这句话第二个线程可能在第一个线程还没释放时执行，就会使用新线程

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

        executorService.shutdown();
    }
}
