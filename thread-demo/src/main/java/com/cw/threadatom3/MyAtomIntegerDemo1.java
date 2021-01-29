package com.cw.threadatom3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 陈小哥cw
 * @date 2021/1/22 16:52
 */
public class MyAtomIntegerDemo1 {
    public static void main(String[] args) {
        AtomicInteger ac = new AtomicInteger();//初始化一个默认值为0的原子型Integer
        System.out.println(ac);

        AtomicInteger ac2 = new AtomicInteger(10);//初始化一个指定值的原子型Integer
        System.out.println("ac2 = " + ac2);
        System.out.println(ac2.get());// 获取值

        int andIncrement = ac2.getAndIncrement();//以原子方式将当前值加1，注意，这里返回的是自增前的值。
        System.out.println("andIncrement = " + andIncrement);
        System.out.println(ac2.get());

        int incrementAndGet = ac2.incrementAndGet();//以原子方式将当前值加1，注意，这里返回的是自增后的值。
        System.out.println("incrementAndGet = " + incrementAndGet);

        int addAndGet = ac2.addAndGet(-1);//以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加，并返回结果。
        System.out.println("addAndGet = " + addAndGet);
        System.out.println(ac2.get());

        int andSet = ac2.getAndSet(20);// 以原子方式设置为newValue的值，并返回旧值。
        System.out.println("andSet = " + andSet);
        System.out.println(ac2.get());

    }
}
