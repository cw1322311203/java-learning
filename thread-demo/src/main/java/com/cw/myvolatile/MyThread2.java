package com.cw.myvolatile;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 15:24
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("小皮取走了10000");
        Money.money = 90000;
    }
}
