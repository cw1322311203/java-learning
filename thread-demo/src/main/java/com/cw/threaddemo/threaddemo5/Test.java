package com.cw.threaddemo.threaddemo5;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 14:10
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*System.out.println("睡觉前");
        Thread.sleep(3000);
        System.out.println("睡醒了");*/

        MyRunnable myRunnable=new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t1.start();
        t2.start();
    }
}
