package com.cw.threaddemo.threaddemo6;

import java.util.concurrent.FutureTask;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 14:29
 * <p>
 * | 方法名                                  | 说明                                                         |
 * | --------------------------------------- | ------------------------------------------------------------ |
 * | final int getPriority()                 | 返回此线程的优先级                                           |
 * | final void setPriority(int newPriority) | 更改此线程的优先级线程默认优先级是5；线程优先级的范围是：1-10 |
 */
public class Test {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread t1 = new Thread(futureTask);
        t1.setName("飞机");
        t1.setPriority(10);
        System.out.println(t1.getPriority());
        t1.start();

        MyCallable myCallable2 = new MyCallable();
        FutureTask<String> futureTask2 = new FutureTask<>(myCallable2);
        Thread t2 = new Thread(futureTask2);
        t2.setName("坦克");
        t2.setPriority(1);
        System.out.println(t2.getPriority());
        t2.start();
    }
}
