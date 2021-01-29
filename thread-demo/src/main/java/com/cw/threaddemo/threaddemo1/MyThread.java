package com.cw.threaddemo.threaddemo1;

/**
 * @author 陈小哥cw
 * @date 2021/1/20 17:16
 *
 * TODO 实现多线程方式一：继承Thread类
 *
 * run()方法的方法体就代表了线程需要完成的任务，因此把run()方法称为线程执行体。
 *
 * Thread线程常用方法：
 * - public void run()：线程执行体
 * - String getName() : 返回该线程的名称。
 * - Thread.currentThread() ：返回当前正在执行的线程对象,是Thread类的静态方法。
 * - void setName(String name) 改变线程名称，使之与参数 name 相同。
 * - Thread() :分配一个新的线程对象
 * - Thread(String name) 分配一个指定名字的新的 Thread 对象。
 * - Thread(Runnable target) 分配一个带有指定目标新的线程对象
 * - Thread(Runnable target,String name) 分配一个带有指定目标新的线程对象并指定名字
 * - int getPriority() 获得线程的优先级数值
 * - void setPriority() 设置线程的优先级数值
 * - void start( ) 调用run( )方法启动线程，开始线程的执行
 * - isAlive() 判断线程是否还“活”着，即线程是未终止
 * - public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。毫秒数结束之后,线程继续执行
 */
public class MyThread extends Thread {
    @Override
    // 在线程开启后，此方法将被调用执行
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程开启了:" + i);
        }
    }
}
