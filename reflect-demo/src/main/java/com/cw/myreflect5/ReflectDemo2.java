package com.cw.myreflect5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method类用于执行方法的方法
 * | 方法名                                    | 说明     |
 * | ----------------------------------------- | -------- |
 * | Object invoke(Object obj, Object... args) | 运行方法 |
 *
 * @author 陈小哥cw
 * @date 2021/1/29 14:54
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //        Object invoke(Object obj, Object... args)：运行方法
        //        参数一：用obj对象调用该方法
        //        参数二：调用方法的传递的参数（如果没有就不写）
        //        返回值：方法的返回值（如果没有就不写）
        // 1.获取class对象
        Class clazz = Class.forName("com.cw.myreflect5.Student");
        // 2.获取Method对象
        Method method = clazz.getMethod("function4", String.class);
        // 3.运行function4方法
        //3.1创建一个Student对象,当做方法的调用者
        Student student = (Student) clazz.newInstance();
        Object result = method.invoke(student, "zhangsan");
        System.out.println(result);

    }
}
