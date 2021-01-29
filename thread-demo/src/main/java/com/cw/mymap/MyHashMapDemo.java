package com.cw.mymap;

import java.util.HashMap;

/**
 * @author 陈小哥cw
 * @date 2021/1/24 15:15
 */
public class MyHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, String> hm = new HashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(i + "", i + "");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(i + "", i + "");
            }
        });

        t1.start();
        t2.start();

        System.out.println("----------------------");

        // 为了t1和t2能把数据全部添加完毕
        Thread.sleep(1000);

        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        }
    }
}
