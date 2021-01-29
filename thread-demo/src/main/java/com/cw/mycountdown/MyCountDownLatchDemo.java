package com.cw.mycountdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author 陈小哥cw
 * @date 2021/1/28 15:20
 */
public class MyCountDownLatchDemo {
    public static void main(String[] args) {
        // 1.创建CountDownLatch的对象，需要传递给4个线程
        // 在底层就定义了一个计数器，此处计数器的值就是3
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 2.创建四个线程对象并开启
        MotherThread motherThread = new MotherThread(countDownLatch);
        motherThread.start();

        ChildThread1 t1 = new ChildThread1(countDownLatch);
        t1.setName("小明");

        ChildThread2 t2 = new ChildThread2(countDownLatch);
        t2.setName("小红");

        ChildThread3 t3 = new ChildThread3(countDownLatch);
        t3.setName("小张");

        t1.start();
        t2.start();
        t3.start();
    }
}
