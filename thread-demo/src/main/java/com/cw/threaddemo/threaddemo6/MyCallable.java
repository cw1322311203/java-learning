package com.cw.threaddemo.threaddemo6;

import java.util.concurrent.Callable;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 14:28
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
        return "线程执行完毕！";
    }
}
