package com.cw.threaddemo.threaddemo4;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 13:20
 */
public class Test {
    // 线程是有默认名字的，格式为:Thread-编号
    public static void main(String[] args) {
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");

        //void setName(String name)：将此线程的名称更改为等于参数 name
//        t1.setName("线程1");
//        t2.setName("线程2");

        t1.start();
        t2.start();

        //static Thread currentThread() 返回对当前正在执行的线程对象的引用
        System.out.println(Thread.currentThread().getName());
    }
}
