package com.cw.myreflect2;

/**
 * 获取class对象的三种方式
 * 1.类名.class属性
 * 2.对象名.getClass()方法
 * 3.Class.forName(全类名)方法
 *
 * @author 陈小哥cw
 * @date 2021/1/29 13:41
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.Class类中的静态方法forName("全类名")
        //全类名:包名 + 类名
        Class clazz = Class.forName("com.cw.myreflect2.Student");
        System.out.println(clazz);

        // 2.通过class属性来获取
        Class clazz2 = Student.class;
        System.out.println(clazz2);

        // 3.通过对象的getClass方法来获取class对象
        // getClass方法是定义在Object类中
        Student student = new Student();
        Class clazz3 = student.getClass();
        System.out.println(clazz3);

        System.out.println(clazz == clazz2);// true
        System.out.println(clazz == clazz3);// true

    }
}
