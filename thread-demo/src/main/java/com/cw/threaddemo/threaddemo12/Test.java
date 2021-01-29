package com.cw.threaddemo.threaddemo12;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 17:10
 */
public class Test {
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (objA) {
                    synchronized (objB) {
                        System.out.println("小康同学在走路");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (objB) {
                    synchronized (objA) {
                        System.out.println("小魏同学在走路");
                    }
                }
            }
        }).start();
    }
}
