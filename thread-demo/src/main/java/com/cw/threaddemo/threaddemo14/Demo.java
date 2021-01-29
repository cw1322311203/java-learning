package com.cw.threaddemo.threaddemo14;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 9:18
 */
public class Demo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(1);

        Foodie f = new Foodie(bd);
        Cooker c = new Cooker(bd);

        f.start();
        c.start();
    }
}
