package com.cw.test4;

import java.util.Random;

/**
 * 无参有返回值抽象方法的练习
 *
 * @author 陈小哥cw
 * @date 2021/1/28 16:28
 */
public class RandomNumHandlerDemo {

    public static void main(String[] args) {
        useRandomNumHandler(new RandomNumHandler() {
            @Override
            public int getNumber() {
                Random r = new Random();
                int num = r.nextInt(10) + 1;
                return num;
            }
        });

        useRandomNumHandler(() -> {
            Random r = new Random();
            int num = r.nextInt(10) + 1;
            // 注意:如果lambda所操作的接口中的方法，有返回值，一定要通过return语句，将结果返回
            // 否则会出现编译错误
            return num;
        });

        useRandomNumHandler(() -> new Random().nextInt(10) + 1);

    }

    public static void useRandomNumHandler(RandomNumHandler randomNumHandler) {
        int result = randomNumHandler.getNumber();
        System.out.println(result);
    }
}

interface RandomNumHandler {
    int getNumber();
}