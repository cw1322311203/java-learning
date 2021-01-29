package com.cw.myreflect5;

import java.lang.reflect.Method;

/**
 * Class类获取成员方法对象的方法
 * | 方法名                                                       | 说明                                       |
 * | ------------------------------------------------------------ | ------------------------------------------ |
 * | Method[] getMethods()                                        | 返回所有公共成员方法对象的数组，包括继承的 |
 * | Method[] getDeclaredMethods()                                | 返回所有成员方法对象的数组，不包括继承的   |
 * | Method getMethod(String name, Class<?>... parameterTypes)    | 返回单个公共成员方法对象                   |
 * | Method getDeclaredMethod(String name, Class<?>... parameterTypes) | 返回单个成员方法对象                       |
 *
 * @author 陈小哥cw
 * @date 2021/1/29 14:47
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        method1();
        System.out.println("-------------------------");
        method2();
        System.out.println("-------------------------");
        method3();
        System.out.println("-------------------------");
        method4();
        System.out.println("-------------------------");
        method5();
    }

    /**
     * Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
     */
    private static void method1() throws ClassNotFoundException {
        //
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect5.Student");
        //2.获取成员方法对象
        Method[] methods = clazz.getMethods();
        //3.遍历
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * Method[] getDeclaredMethods()：返回所有成员方法对象的数组，不包括继承的
     */
    private static void method2() throws ClassNotFoundException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect5.Student");

        //2.获取Method对象
        Method[] methods = clazz.getDeclaredMethods();
        //3.遍历一下数组
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * Method getMethod(String name, Class<?>... parameterTypes) ：返回单个公共成员方法对象
     */
    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect5.Student");
        //2.获取成员方法function1
        Method method1 = clazz.getMethod("function1");// 返回无参公共成员方法
        //3.打印一下
        System.out.println(method1);
    }


    /**
     * Method getMethod(String name, Class<?>... parameterTypes) ：返回单个公共(public)成员方法对象
     */
    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect5.Student");
        //2.获取一个有形参的方法function2
        Method method = clazz.getMethod("function2", String.class);// 返回有参公共成员方法
        //3.打印一下
        System.out.println(method);
    }

    /**
     * Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象(private也可)
     */
    private static void method5() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect5.Student");
        //2.获取一个成员方法show
        Method method = clazz.getDeclaredMethod("show");
        //3.打印一下
        System.out.println(method);
    }
}
