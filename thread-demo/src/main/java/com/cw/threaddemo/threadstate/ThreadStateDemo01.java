package com.cw.threaddemo.threadstate;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 13:17
 *
 * 演示TIME_WAITING的状态转换。
 */
public class ThreadStateDemo01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("2.执行thread.start()之后，线程的状态：" + Thread.currentThread().getState());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4.执行Thread.sleep(long)完成之后，线程的状态：" + Thread.currentThread().getState());
        });

        // 获取start之前的状态
        System.out.println("1.通过new初始化一个线程，但是还没有start()之前，线程的状态：" + thread.getState());

        // 启动线程
        thread.start();

        // 休眠50毫秒
        Thread.sleep(50);

        System.out.println("3.执行Thread.sleep(long)时，线程的状态：" + thread.getState());

        // thread1和main线程主动休眠150毫秒，所以在第150毫秒,thread早已执行完毕
        Thread.sleep(100);

        System.out.println("5.线程执行完毕之后，线程的状态：" + thread.getState() + "\n");
    }
}
