package com.cw.myanno3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 陈小哥cw
 * @date 2021/1/29 9:27
 */
public class AnnoDemo {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        // 1.通过反射获取UseTest类的字节码文件对象
        Class<?> clazz = Class.forName("com.cw.myanno3.UseTest");

        // 创建对象
        UseTest useTest = new UseTest();

        // 2.通过反射获取这个类里面所有的方法对象
        Method[] methods = clazz.getDeclaredMethods();

        // 3.遍历数组，得到每一个方法对象
        for (Method method : methods) {
            // method依次表示每一个方法对象
            // isAnnotationPresent(Class<? extends Annotation> annotationClass)
            // 判断当前方法上是否有指定的注解。
            // 参数：注解的字节码文件对象
            // 返回值：布尔结果。  true 存在  false 不存在
            if (method.isAnnotationPresent(Test.class)) {
                method.invoke(useTest);
            }
        }

    }
}
