package com.cw.threaddemo.threaddemo14;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 9:14
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // 创建阻塞队列的对象,容量为 1
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        // 存储元素
        arrayBlockingQueue.put("汉堡包");

        // 取元素
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());// 取不到会阻塞

        System.out.println("程序结束了");
    }
}
