package com.cw.myreflect4;

import java.lang.reflect.Field;

/**
 * Class类获取成员变量对象的方法
 * <p>
 * | 方法名                              | 说明                           |
 * | ----------------------------------- | ------------------------------ |
 * | Field[] getFields()                 | 返回所有公共成员变量对象的数组 |
 * | Field[] getDeclaredFields()         | 返回所有成员变量对象的数组     |
 * | Field getField(String name)         | 返回单个公共成员变量对象       |
 * | Field getDeclaredField(String name) | 返回单个成员变量对象           |
 *
 * @author 陈小哥cw
 * @date 2021/1/29 14:29
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //method1();
        //method2();
        //method3();
        method4();
    }


    /**
     * Field[] getFields()：返回所有公共成员变量对象的数组
     */
    public static void method1() throws ClassNotFoundException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect4.Student");

        //2.获取Field对象
        Field[] fields = clazz.getFields();

        //3.遍历
        for (Field field : fields) {
            //public java.lang.String com.cw.myreflect4.Student.name
            //public int com.cw.myreflect4.Student.age
            //public java.lang.String com.cw.myreflect4.Student.gender
            System.out.println(field);
        }
    }

    /**
     * Field[] getDeclaredFields()：返回所有成员变量对象的数组
     */
    public static void method2() throws ClassNotFoundException {
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect4.Student");

        //2.获取所有的Field对象
        Field[] fields = clazz.getDeclaredFields();

        //3.遍历
        for (Field field : fields) {
            //public java.lang.String com.cw.myreflect4.Student.name
            //public int com.cw.myreflect4.Student.age
            //public java.lang.String com.cw.myreflect4.Student.gender
            //private int com.cw.myreflect4.Student.money
            System.out.println(field);
        }
    }

    /**
     * Field getField(String name)：返回单个公共成员变量对象
     */
    public static void method3() throws ClassNotFoundException, NoSuchFieldException {
        //想要获取的成员变量必须是真实存在的
        //且必须是public修饰的.
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect4.Student");

        //2.获取name这个成员变量
        //Field field = clazz.getField("name");
        //Field field = clazz.getField("name1");
        Field field = clazz.getField("money");// money为私有，无法获取

        //3.打印一下
        System.out.println(field);
    }

    /**
     * Field getDeclaredField(String name)：返回单个成员变量对象
     */
    public static void method4() throws ClassNotFoundException, NoSuchFieldException {
        // Field getDeclaredField(String name)：返回单个成员变量对象
        //1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect4.Student");

        //2.获取money成员变量
        Field field = clazz.getDeclaredField("money");

        //3.打印一下
        System.out.println(field);
    }
}
