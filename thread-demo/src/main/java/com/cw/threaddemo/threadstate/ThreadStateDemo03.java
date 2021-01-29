package com.cw.threaddemo.threadstate;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 13:30
 * <p>
 * 演示BLOCKED的状态转换
 */
public class ThreadStateDemo03 {
    public static void main(String[] args) throws InterruptedException {
        //定义一个对象，用来加锁和解锁
        Object obj2 = new Object();

        // 定义一个线程，先抢占了obj2对象的锁
        new Thread(() -> {
            synchronized (obj2) {
                try {
                    Thread.sleep(100); //第一个线程要持有锁100毫秒
                    obj2.wait();//然后通过wait()方法进行等待状态，并释放obj2的对象锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 定义目标线程，获取等待获取obj2的锁
        Thread thread = new Thread(() -> {
            System.out.println("2.执行thread.start()之后，线程的状态：" + Thread.currentThread().getState());
            synchronized (obj2) {
                try {
                    Thread.sleep(100);//thread3要持有对象锁100毫秒
                    obj2.notify();//然后通过notify()方法唤醒所有在ojb2上等待的线程继续执行后
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("4.阻塞结束后，线程的状态：" + Thread.currentThread().getState());
        });


        //获取start()之前的状态
        System.out.println("1.通过new初始化一个线程，但是还没有thread.start()之前，线程的状态：" + thread.getState());

        //启动线程
        thread.start();

        //先等100毫秒
        Thread.sleep(50);

        //第一个线程释放锁至少需要100毫秒，所以在第50毫秒时，thread正在因等待obj的对象锁而阻塞
        System.out.println("3.因为等待锁而阻塞时，线程的状态：" + thread.getState());

        //再等300毫秒
        Thread.sleep(300);

        //两个线程的执行时间加上之前等待的50毫秒总共是250毫秒，所以第300毫秒，所有的线程都已经执行完毕
        System.out.println("5.线程执行完毕之后，线程的状态：" + thread.getState());
    }
}
