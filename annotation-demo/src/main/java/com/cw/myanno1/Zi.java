package com.cw.myanno1;

/**
 * 注解的作用：对我们的程序进行标注和解释
 *
 * 注解和注释的区别
 * + 注释: 给程序员看的
 * + 注解: 给编译器看的
 *
 * @author 陈小哥cw
 * @date 2021/1/29 9:06
 */
// 表示压制本类中所有的警告
@SuppressWarnings(value = "all")
public class Zi extends Fu {

    // 告诉编译器这个方法是重写了父类中的show方法，那么我们在进行方法定义时，就需要按照重写方法的要求进行方法定义
    @Override
    public void show() {
        System.out.println("子类的方法");
        method();
    }

    // 表示这是一个过时的方法
    @Deprecated
    public void method() {
        System.out.println("method.....");
    }

    // 表示压制本方法中所有的警告
    @SuppressWarnings(value = "all")
    public void function() {
        int a = 10;
        int b = 20;
    }

    public void function2() {
        int c = 30;
        int d = 40;
    }
}
