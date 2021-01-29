package com.cw.threaddemo.threaddemo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 陈小哥cw
 * @date 2021/1/21 9:51
 *
 * 实现步骤:
 * 1.创建Callable接口的实现类,并实现call()方法,该call()方法将作为线程执行体，且该方法有返回值
 * public class RandomCallable implements Callable<Integer>{
 *     public Integer call() throws Exception {｝
 * ｝
 * 2.创建Callable实现类的实例。
 * Callable callable =new RandomCallable();
 * 3.使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值
 * FutureTask<Integer> task = new FutureTask(callable);
 * 4.使用FutureTask对象作为Thread对象的target创建并启动新线程.
 * Thread thread = new Thread(task);
 * thread.start();
 * 5.调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。
 * int result = task.get();//要等线程返回结果，程序再次阻塞
 * System.out.println(result);
 *
 * 注意:get()方法会返回Callable任务里call()方法的返回值。调用该方法将会导致程序阻塞，必须等到子线程结束后才会得到返回值。
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程开启之后需要执行里面的call方法
        MyCallable myCallable = new MyCallable();
        // 可以获取线程执行完毕之后的结果，也可以作为参数传递给Thread对象
        FutureTask<String> futureTask = new FutureTask<String>(myCallable);
        // 创建线程对象
        Thread t1 = new Thread(futureTask);

        // get获取线程运行之后的结果，如果线程还没有运行结束，那么get方法会在这里一直等待
        // String s = futureTask.get();
        // 开启线程
        t1.start();

        // get方法必须在start方法之后调用
        String s = futureTask.get();
        System.out.println(s);
    }
}
