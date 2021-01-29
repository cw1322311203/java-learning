package com.cw.threaddemo.threaddemo1;

/**
 * @author 陈小哥cw
 * @date 2021/1/20 17:18
 * <p>
 * 为什么要重写run()方法？
 * - 因为run()是用来封装被线程执行的代码
 * run()方法和start()方法的区别？
 * - run()：封装线程执行的代码，直接调用，相当于普通方法的调用
 * - start()：启动线程；然后由JVM调用此线程的run()方法(启动线程，不见得立刻执行，而是进入就绪队列，等待获得CPU，也不会一直占用CPU,分时间片交替执行)
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.run();// 表示的仅仅是创建对象，用对象去调用方法，并没有开启线程
        t2.run();

        /**
         * void start()
         * 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
         * 结果是两个线程并发地运行；当前线程（main线程）和另一个线程（创建的新线程,执行其 run 方法）。
         * 多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
         * java程序属于抢占式调度,那个线程的优先级高,那个线程优先执行;同一个优先级,随机选择一个执行
         */
        t1.start();//使此线程开始执行，Java虚拟机会调用run方法()
        t2.start();
    }
}
