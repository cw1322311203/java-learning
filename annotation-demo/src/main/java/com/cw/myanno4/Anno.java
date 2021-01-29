package com.cw.myanno4;

import java.lang.annotation.*;

/**
 * 元注解就是描述注解的注解
 * | 元注解名    | 说明                                    |
 * | ----------- | --------------------------------------- |
 * | @Target     | 指定了注解能在哪里使用                  |
 * | @Retention  | 可以理解为保留时间(生命周期)            |
 * | @Inherited  | 表示修饰的自定义注解可以被子类继承      |
 * | @Documented | 表示该自定义注解，会出现在API文档里面。 |
 *
 * @author 陈小哥cw
 * @date 2021/1/29 9:43
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD}) //指定注解使用的位置（成员变量，类，方法）
@Retention(RetentionPolicy.RUNTIME) // 指定该注解的存活时间
@Inherited// 指定该注解可以被继承
public @interface Anno {
}
