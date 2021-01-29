package com.cw.threaddemo.threaddemo10;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 16:21
 * <p>
 * 同步方法的锁对象是this
 */
public class MyRunnable implements Runnable {

    private static int ticketCount = 100;


    @Override
    public void run() {
        while (true) {
            if ("窗口一".equals(Thread.currentThread().getName())) {
                // 同步方法
                boolean result = synchronizedMethod();
                if (result) {
                    break;
                }
            }

            if ("窗口二".equals(Thread.currentThread().getName())) {
                // 同步代码块
                synchronized (MyRunnable.class) {
                    if (ticketCount == 0) {
                        break;
                    } else {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticketCount--;
                        System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticketCount + "张票");
                    }
                }
            }
        }
    }

    private static synchronized boolean synchronizedMethod() {
        if (ticketCount == 0) {
            return true;
        } else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticketCount + "张票");
            return false;
        }
    }
}
