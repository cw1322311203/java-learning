package com.cw.test5;

/**
 * 有参有返回值抽象方法的练习
 *
 * @author 陈小哥cw
 * @date 2021/1/28 16:38
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        useCalculator(new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });


        useCalculator((int a, int b) -> {
            return a + b;
        });

        useCalculator((a, b) -> a + b);

    }

    public static void useCalculator(Calculator calculator) {
        int result = calculator.calc(10, 20);
        System.out.println(result);
    }
}

interface Calculator {
    int calc(int a, int b);
}
