package com.cw.mycountdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author 陈小哥cw
 * @date 2021/1/28 15:23
 */
public class ChildThread3 extends Thread {

    private CountDownLatch countDownLatch;

    public ChildThread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // 1.吃饺子
        for (int i = 1; i <= 20; i++) {
            System.out.println(getName() + "在吃第" + i + "个饺子");
        }

        // 2.吃完说一声
        // 每一次调用countDown方法时，就让计数器-1
        countDownLatch.countDown();
    }
}
