package com.cw.mysemaphore;

/**
 * @author 陈小哥cw
 * @date 2021/1/28 15:37
 */
public class MySemaphoreDemo {
    public static void main(String[] args) {

        MyRunnable mr = new MyRunnable();

        for (int i = 0; i < 100; i++) {
            new Thread(mr).start();
        }
    }
}
