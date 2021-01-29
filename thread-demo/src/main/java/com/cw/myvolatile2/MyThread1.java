package com.cw.myvolatile2;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 15:22
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {

        while (true) {
            synchronized (Money.lock) {
                if (Money.money != 100000) {
                    System.out.println("结婚基金已经不是十万");
                    break;
                } else {
                    System.out.println("结婚基金为:" + Money.money);
                }
            }
        }


    }
}
