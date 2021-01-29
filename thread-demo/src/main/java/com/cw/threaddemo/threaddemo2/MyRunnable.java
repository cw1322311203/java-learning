package com.cw.threaddemo.threaddemo2;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 9:06
 * <p>
 * TODO 实现多线程方式二：实现Runnable接口
 * <p>
 * 实现Runnable接口创建多线程程序的好处:
 * 1.避免了单继承的局限性
 * 一个类只能继承一个类(一个人只能有一个亲爹),类继承了Thread类就不能继承其他的类
 * 实现了Runnable接口,还可以继承其他的类,实现其他的接口
 * 2.增强了程序的扩展性,降低了程序的耦合性(解耦)
 * 实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解耦)
 * 实现类中,重写了run方法:用来设置线程任务
 * 创建Thread类对象,调用start方法:用来开启新线程
 */
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "第二种方式实现多线程:" + i);
        }
    }
}
