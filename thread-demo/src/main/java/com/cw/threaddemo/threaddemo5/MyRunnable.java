package com.cw.threaddemo.threaddemo5;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 14:19
 * <p>
 * 如果一个类或者一个接口里的方法没用抛出异常，那么其子类或者实现类重写的方法就不能抛出异常
 */
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
