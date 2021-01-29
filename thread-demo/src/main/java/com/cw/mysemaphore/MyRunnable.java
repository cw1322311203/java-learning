package com.cw.mysemaphore;

import java.util.concurrent.Semaphore;

/**
 * @author 陈小哥cw
 * @date 2021/1/28 15:38
 */
public class MyRunnable implements Runnable {

    // 1.获得管理员对象
    // 最多运行两个线程执行
    private Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        // 2.获得通行证
        try {
            semaphore.acquire();
            // 3.开始行驶
            System.out.println("获得了通行证开始行驶");
            Thread.sleep(2000);
            System.out.println("归还通行证");
            // 4.归还通行证
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
