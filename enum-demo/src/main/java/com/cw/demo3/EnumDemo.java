package com.cw.demo3;

/**
 * @author 陈小哥cw
 * @date 2021/1/29 8:52
 */
public class EnumDemo {
    public static void main(String[] args) {
        /**
         * | 方法名                                            | 说明                                 |
         * | ------------------------------------------------- | ------------------------------------ |
         * | String name()                                     | 获取枚举项的名称                     |
         * | int ordinal()                                     | 返回枚举项在枚举类中的索引值         |
         * | int compareTo(E  o)                               | 比较两个枚举项，返回的是索引值的差值 |
         * | String toString()                                 | 返回枚举常量的名称                   |
         * | static <T> T  valueOf(Class<T> type,String  name) | 获取指定枚举类中的指定名称的枚举值   |
         * | values()                                          | 获得所有的枚举项                     |
         */
        String name = Season.SPRING.name();
        System.out.println(name);


        System.out.println("-------------------------------");


        int index1 = Season.SPRING.ordinal();
        int index2 = Season.SUMMER.ordinal();
        int index3 = Season.AUTUMN.ordinal();
        int index4 = Season.WINTER.ordinal();
        System.out.println("index1 = " + index1);// 0
        System.out.println("index2 = " + index2);// 1
        System.out.println("index3 = " + index3);// 2
        System.out.println("index4 = " + index4);// 3

        System.out.println("-------------------------------");

        int result = Season.SPRING.compareTo(Season.WINTER);
        System.out.println("result = " + result);// -3

        System.out.println("-------------------------------");

        String s = Season.SPRING.toString();
        System.out.println("s = " + s);

        System.out.println("-------------------------------");

        Season spring = Enum.valueOf(Season.class, "SPRING");
        System.out.println("spring = " + spring);// SPRING
        System.out.println(Season.SPRING == spring);// true

        System.out.println("-------------------------------");

        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }

    }
}
