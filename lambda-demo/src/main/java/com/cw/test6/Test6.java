package com.cw.test6;

/**
 * 省略的规则
 * <p>
 * - 参数类型可以省略。但是有多个参数的情况下，不能只省略一个
 * - 如果参数有且仅有一个，那么小括号可以省略
 * - 如果代码块的语句只有一条，可以省略大括号和分号，和return关键字（要么全部省略，要么都不省略）
 *
 * @author 陈小哥cw
 * @date 2021/1/28 16:41
 */
public class Test6 {
    public static void main(String[] args) {
        useInter((double a, double b) -> {
            return a + b;
        });

        // 省略模式
        useInter((a, b) -> a + b);
    }

    public static void useInter(Inter i) {
        double result = i.method(12.3, 22.3);
        System.out.println("result = " + result);
    }
}

interface Inter {
    // 用于计算a+b的结果并返回
    double method(double a, double b);
}