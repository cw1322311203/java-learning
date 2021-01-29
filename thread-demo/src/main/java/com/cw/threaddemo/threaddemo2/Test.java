package com.cw.threaddemo.threaddemo2;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 9:26
 * <p>
 * Thread(Runnable target) 分配新的 Thread 对象。
 * Thread(Runnable target, String name) 分配新的 Thread 对象。
 * <p>
 * Thread类实际上也是实现了Runnable接口的类。实际上所有的多线程代码都是通过运行Thread的start()方法来运行的。
 * 因此，不管是继承Thread类还是实现Runnable接口来实现多线程，最终还是通过Thread的对象的API来控制线程的。
 * 注意：Runnable对象仅仅作为Thread对象的target，Runnable实现类里包含的run()方法仅作为线程执行体。
 * 而实际的线程对象依然是Thread实例，只是该Thread线程负责执行其target的run()方法
 */
public class Test {
    public static void main(String[] args) {
        // 创建了一个参数的对象
        MyRunnable myRunnable = new MyRunnable();
        // 创建了一个线程对象，并把参数传递给这个线程
        // 在线程启动之后，执行的就是参数里面的run方法
        Thread t1 = new Thread(myRunnable);
        // 开启线程
        t1.start();

        MyRunnable myRunnable1 = new MyRunnable();
        Thread t2 = new Thread(myRunnable1);
        t2.start();

    }
}
