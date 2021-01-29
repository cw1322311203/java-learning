package com.cw.test1;

/**
 * Lambda表达式的使用前提
 * - 使用Lambda必须要有接口
 * - 并且要求接口中有且仅有一个抽象方法
 *
 * Lambda表达式和匿名内部类的区别
 * 1.所需类型不同
 * - 匿名内部类：可以是接口，也可以是抽象类，还可以是具体类
 * - Lambda表达式：只能是接口
 * 2.使用限制不同
 * - 如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类
 * - 如果接口中多于一个抽象方法，只能使用匿名内部类，而不能使用Lambda表达式
 * 3.实现原理不同
 * - 匿名内部类：编译之后，产生一个单独的.class字节码文件(Test$1.class)
 * - Lambda表达式：编译之后，没有一个单独的.class字节码文件。对应的字节码会在运行的时候动态生成
 *
 * @author 陈小哥cw
 * @date 2021/1/28 15:54
 */
public class TestSwimming {
    public static void main(String[] args) {
        // 通过匿名内部类实现
        goSwimming(new Swimming() {
            public void swim() {
                System.out.println("大兄弟，一块游泳吧！");
            }
        });

        /**
         * 通过Lambda表达式实现
         * 理解: 对于Lambda表达式, 对匿名内部类进行了优化
         */
        goSwimming(() -> {
            System.out.println("大兄弟，一块游泳吧！");
        });

        goSwimming(() -> System.out.println("大兄弟，一块游泳吧！"));
    }

    /**
     * 使用接口的方法
     *
     * @param swimming
     */
    public static void goSwimming(Swimming swimming) {
        swimming.swim();
    }
}


interface Swimming {
    void swim();
}