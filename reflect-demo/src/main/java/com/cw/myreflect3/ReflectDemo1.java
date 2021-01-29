package com.cw.myreflect3;

import java.lang.reflect.Constructor;

/**
 * Class类获取构造方法对象的方法
 * <p>
 * | 方法名                                                       | 说明                           |
 * | ------------------------------------------------------------ | ------------------------------ |
 * | Constructor<?>[] getConstructors()                           | 返回所有公共构造方法对象的数组 |
 * | Constructor<?>[] getDeclaredConstructors()                   | 返回所有构造方法对象的数组     |
 * | Constructor<T> getConstructor(Class<?>... parameterTypes)    | 返回单个公共构造方法对象       |
 * | Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) | 返回单个构造方法对象           |
 *
 * @author 陈小哥cw
 * @date 2021/1/29 13:51
 */

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException {
        //method1();
        // method2();
        // method3();
        // method4();
    }


    public static void method1() throws ClassNotFoundException {
        //  Constructor<?>[] getConstructors()：
        //   返回所有公共(public修饰)构造方法对象的数组,private修饰的构造方法无法获取
        Class clazz = Class.forName("com.cw.myreflect3.Student");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            //public com.cw.myreflect3.Student()
            //public com.cw.myreflect3.Student(java.lang.String,int)
            System.out.println(constructor);
        }
    }

    public static void method2() throws ClassNotFoundException {
        // Constructor<?>[] getDeclaredConstructors()：
        // 返回所有构造方法对象的数组，private修饰的构造方法也可以获取
        Class clazz = Class.forName("com.cw.myreflect3.Student");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            //private com.cw.myreflect3.Student(java.lang.String)
            //public com.cw.myreflect3.Student()
            //public com.cw.myreflect3.Student(java.lang.String,int)
            System.out.println(constructor);
        }
    }


    public static void method3() throws ClassNotFoundException, NoSuchMethodException {
        // Constructor<T> getConstructor(Class<?>... parameterTypes)：
        // 返回单个公共构造方法对象
        Class clazz = Class.forName("com.cw.myreflect3.Student");
        //小括号中,一定要跟构造方法的形参保持一致
        Constructor constructor1 = clazz.getConstructor();
        System.out.println(constructor1);// public com.cw.myreflect3.Student()

        Constructor constructor2 = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor2);// public com.cw.myreflect3.Student(java.lang.String,int)

        //因为Student类中,没有只有一个int的构造,所以这里会报错
        Constructor constructor3 = clazz.getConstructor(int.class);
        System.out.println(constructor3);
    }

    public static void method4() throws ClassNotFoundException, NoSuchMethodException {
        // Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：
        // 返回单个构造方法对象
        Class clazz = Class.forName("com.cw.myreflect3.Student");
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println(constructor);
    }
}
