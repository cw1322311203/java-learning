package com.cw.myanno4;

/**
 * @author 陈小哥cw
 * @date 2021/1/29 9:46
 */
public class StudentDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到Student类的字节码文件对象
        Class clazz = Class.forName("com.cw.myanno4.Student");

        //获取注解。
        boolean result = clazz.isAnnotationPresent(Anno.class);
        System.out.println(result);
    }
}
