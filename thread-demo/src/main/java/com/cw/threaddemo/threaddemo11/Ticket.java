package com.cw.threaddemo.threaddemo11;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 15:38
 */
public class Ticket implements Runnable {
    // 票的数量
    private int ticket = 100;
    private Object obj = new Object();
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket <= 0) {
                    // 卖完了
                    break;
                } else {
                    Thread.sleep(100);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticket + "张票");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
