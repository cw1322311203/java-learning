package com.cw.threadpool;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 14:43
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "在执行了");
    }
}
