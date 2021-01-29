package com.cw.threaddemo.threaddemo10;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 16:27
 */
public class Test {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}
