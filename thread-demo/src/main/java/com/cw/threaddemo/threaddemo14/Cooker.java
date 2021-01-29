package com.cw.threaddemo.threaddemo14;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 17:32
 */
public class Cooker extends Thread {
    private ArrayBlockingQueue<String> bd;

    public Cooker(ArrayBlockingQueue<String> bd) {
        this.bd = bd;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bd.put("汉堡包");
                // 结果会出现重复的因为输出语句没放在锁里，take和put底层代码默认加了锁
                System.out.println("厨师放入一个汉堡包");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
