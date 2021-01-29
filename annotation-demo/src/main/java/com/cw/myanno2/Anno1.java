package com.cw.myanno2;

/**
 * 自定义注解格式
 * public @interface 注解名称 {
 * ​	public 属性类型 属性名() default 默认值 ;
 * }
 * <p>
 * 属性类型
 * + 基本数据类型
 * + String
 * + Class
 * + 注解
 * + 枚举
 * + 以上类型的一维数组
 *
 * @author 陈小哥cw
 * @date 2021/1/29 9:15
 */
public @interface Anno1 {
    // 定义一个基本类型的属性
    int a() default 23;

    // 定义一个String类型的属性
    public String name() default "cw";

    // 定义一个Class类型的属性
    public Class clazz() default Anno2.class;

    // 定义一个注解类型的属性
    public Anno2 anno() default @Anno2;

    // 定义一个枚举类型的属性
    public Season season() default Season.SPRING;

    // 以上类型的一维数组
    // int数组
    public int[] arr() default {1, 2, 3, 4, 5};

    // 枚举数组
    public Season[] seasons() default {Season.SPRING, Season.SUMMER};

    //value。后期我们在使用注解的时候，如果我们只需要给注解的value属性赋值。
    //那么value就可以省略
    public String value();
}
