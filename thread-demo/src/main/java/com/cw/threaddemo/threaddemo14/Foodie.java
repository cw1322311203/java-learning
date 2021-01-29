package com.cw.threaddemo.threaddemo14;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 17:28
 */
public class Foodie extends Thread {

    private ArrayBlockingQueue<String> bd;

    public Foodie(ArrayBlockingQueue<String> bd) {
        this.bd = bd;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String take = bd.take();
                // 结果会出现重复的因为输出语句没放在锁里，take和put底层代码默认加了锁
                System.out.println("吃货将" + take + "拿出来吃了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
