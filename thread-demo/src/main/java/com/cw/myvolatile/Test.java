package com.cw.myvolatile;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 15:25
 */
public class Test {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.setName("小路");
        t1.start();

        MyThread2 t2 = new MyThread2();
        t2.setName("小皮");
        t2.start();
    }
}
