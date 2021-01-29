package com.cw.threaddemo.threaddemo3;

import java.util.concurrent.Callable;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 9:50
 * TODO 实现多线程方式三: 实现Callable接口
 * Callable接口可以看作是Runnable接口的补充，call方法带有返回值，并且可以抛出异常。
 * Callable接口提供了一个call()方法作为线程执行体,但call()方法比run()方法功能更强大。
 * Java 5提供了Future接口来代表Callable接口里call()方法的返回值，并为Future接口提供了一个FutureTask实现类，
 * 该实现类实现了Future接口，并实现了Runnable接口-----可以作为Thread类的target。
 * <p>
 * TODO 认识Callable
 * 1.有返回值
 * 2.支持泛型
 * 3.支持异常抛出(runable只能抛出运行时异常，而Callable可以抛出所有的异常)
 * 4.JDK1.5提供
 * 5.功能强大，如果需要返回值，必须使用该方式
 * 6.java.util.concurrent.Callable是一个泛型接口，只有一个call()方法
 * 7.call()方法抛出异常Exception异常，且返回一个指定的泛型类对象
 * 注意:Callable接口有泛型限制，Callable接口里的泛型形参类型与call()方法返回值类型相同
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("表白:" + i + "次");
        }

        // 返回值就表示线程运行完毕之后的结果
        return "答应表白";
    }
}
