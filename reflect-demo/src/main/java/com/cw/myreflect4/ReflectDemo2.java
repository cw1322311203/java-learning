package com.cw.myreflect4;

import java.lang.reflect.Field;

/**
 * Field类用于给成员变量赋值和获取值的方法
 * | 方法名                             | 说明   |
 * | ---------------------------------- | ------ |
 * | void set(Object obj, Object value) | 赋值   |
 * | Object get(Object obj)             | 获取值 |
 *
 * @author 陈小哥cw
 * @date 2021/1/29 14:38
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //method1();
        //method2();
    }


    /**
     * void set(Object obj, Object value)：给obj对象的成员变量赋值为value
     */
    public static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect4.Student");

        //2.获取name这个Field对象
        Field field = clazz.getField("name");

        // 3.利用set方法进行赋值
        //3.1先创建一个Student对象
        Student student = (Student) clazz.newInstance();
        //3.2有了对象才可以给指定对象进行赋值
        field.set(student, "zhangsan");

        System.out.println(student);
    }

    /**
     * Object get(Object obj) 返回由该 Field表示的字段在指定对象上的值。
     */
    public static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect4.Student");

        //2.获取成员变量Field的对象
        Field field = clazz.getDeclaredField("money");

        //3.取消一下访问检查
        field.setAccessible(true);

        //4.调用get方法来获取值
        //4.1创建一个对象
        Student student = (Student) clazz.newInstance();
        //4.2获取指定对象的money的值
        Object o = field.get(student);

        //5.打印一下
        System.out.println(o);
    }
}
