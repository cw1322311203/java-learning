package com.cw.threaddemo.threaddemo4;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 13:19
 */
public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "@@@" + i);
        }
    }
}
