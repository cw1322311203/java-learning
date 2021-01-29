package com.cw.threaddemo.threaddemo7;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 15:07
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "---" + i);
        }
    }
}
