package com.cw.myvolatile;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 15:22
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        while (Money.money == 100000) {
            System.out.println("结婚基金为:" + Money.money);
        }
        System.out.println("结婚基金已经不是十万");
    }
}
