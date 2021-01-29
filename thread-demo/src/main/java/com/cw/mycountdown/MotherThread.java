package com.cw.mycountdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author 陈小哥cw
 * @date 2021/1/28 15:21
 */
public class MotherThread extends Thread {

    private CountDownLatch countDownLatch;

    public MotherThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // 1.等待
        try {
            // 当计数器变成0的时候，会自动唤醒这里等待的线程。
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2.收拾碗筷
        System.out.println("妈妈在收拾碗筷");

    }
}
