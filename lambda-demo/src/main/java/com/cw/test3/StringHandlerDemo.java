package com.cw.test3;

/**
 * 有参无返回值抽象方法的练习
 *
 * @author 陈小哥cw
 * @date 2021/1/28 16:13
 */
public class StringHandlerDemo {

    public static void main(String[] args) {
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("我是匿名内部类" + msg);
            }
        });

        useStringHandler((String msg) -> {
            System.out.println("我是lambda表达式" + msg);
        });

        useStringHandler((msg)-> System.out.println("我是lambda表达式" + msg));

    }

    public static void useStringHandler(StringHandler stringHandler) {
        stringHandler.printMessage("cw");
    }
}

interface StringHandler {
    void printMessage(String msg);
}